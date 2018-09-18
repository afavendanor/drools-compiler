package co.com.suramericana.service.versioncontrol.implementation;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.eclipse.jgit.api.CheckoutCommand;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PullCommand;
import org.eclipse.jgit.api.PullResult;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.errors.RepositoryNotFoundException;
import org.eclipse.jgit.merge.MergeStrategy;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.pmw.tinylog.Logger;

import co.com.suramericana.domain.RepositoryProperties;
import co.com.suramericana.exception.TechnicalException;
import co.com.suramericana.service.versioncontrol.GitManagement;

public class GitManagementImpl implements GitManagement {

    private final String remoteUrl;
    private final String baseMessage;
    private final String filePattern;
    private final UsernamePasswordCredentialsProvider credentials;
    private final File localRepository;
    private final Git repo;

    private static final StringBuilder COMMIT_MESSAGE = new StringBuilder();

    public GitManagementImpl(RepositoryProperties repositoryProperties) {
        remoteUrl = repositoryProperties.getRemoteUrl();
        baseMessage = repositoryProperties.getBaseMessage();
        filePattern = repositoryProperties.getFilePattern();
        credentials = repositoryProperties.getCredentials();
        localRepository = repositoryProperties.getLocalRepository();
        repo = getRepository();
    }

    public void synchronize() {
        try {
            repo.add().addFilepattern(filePattern).call();
            final Set<String> uncommittedChanges = repo.status().call().getUncommittedChanges();
            COMMIT_MESSAGE.append(baseMessage);
            uncommittedChanges.forEach(s -> COMMIT_MESSAGE.append(s).append(" "));
            repo.commit().setMessage(COMMIT_MESSAGE.toString()).call();
            repo.fetch().setCredentialsProvider(credentials).call();
            final PullCommand pullCommand = repo.pull().setStrategy(MergeStrategy.RECURSIVE);
            final PullResult pullResult = pullCommand.setCredentialsProvider(credentials).call();
            final boolean mergeResult = pullResult.getMergeResult().getMergeStatus().isSuccessful();
            Logger.debug("Merge status: " + mergeResult);
            if (!mergeResult) {
                resolveConflicts(pullResult);
            }
            repo.push().setCredentialsProvider(credentials).call();
        } catch (GitAPIException e) {
            throw new TechnicalException(e.getMessage(), e);
        }
    }

    private Git getRepository(){
        Git repository = null;
        try {
            repository = Git.open(localRepository);
        } catch (RepositoryNotFoundException e) {
            Logger.debug(e,"The repository didn´t exist, it was created!");
            repository = cloneRepository();
        } catch (IOException e) {
            throw new TechnicalException(e.getMessage(), e);
        }
        return repository;
    }

    private Git cloneRepository() {
        try {
            FileUtils.cleanDirectory(localRepository);
            final CloneCommand cloneCommand = Git.cloneRepository();
            cloneCommand.setURI(remoteUrl).setDirectory(localRepository)
                    .setCredentialsProvider(credentials).call();
            return Git.open(localRepository);
        } catch (IOException | GitAPIException e) {
            throw new TechnicalException(e.getMessage(), e);
        }
    }

    private void resolveConflicts(PullResult pullResult) {
        if (pullResult.getMergeResult() != null
                && pullResult.getMergeResult().getConflicts() != null
                && pullResult.getMergeResult().getConflicts().size() > 0) {
            final Iterator conflictingFiles = pullResult.getMergeResult().getConflicts().keySet().iterator();
            while (conflictingFiles.hasNext()) {
                final String conflictFile = (String) conflictingFiles.next();
                Logger.debug("File in conflict: " + conflictFile);
                try {
                    repo.checkout().setStage(CheckoutCommand.Stage.OURS).addPath(conflictFile).call();
                    repo.add().addFilepattern(".").call();
                    repo.commit().call();
                } catch (GitAPIException e) {
                    throw new TechnicalException(e.getMessage(), e);
                }
            }
        }
    }

}
