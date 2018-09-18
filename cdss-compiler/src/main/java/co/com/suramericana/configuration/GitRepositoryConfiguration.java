package co.com.suramericana.configuration;

import co.com.suramericana.domain.RepositoryProperties;
import co.com.suramericana.service.versioncontrol.FileManagement;
import co.com.suramericana.service.versioncontrol.GitManagement;
import co.com.suramericana.service.versioncontrol.implementation.FileManagementImpl;
import co.com.suramericana.service.versioncontrol.implementation.GitManagementImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GitRepositoryConfiguration {

    @Value("${git.url.remote}")
    private String remoteUrl;
    @Value("${git.uri.local}")
    private String localUri;
    @Value("${git.username}")
    private String userName;
    @Value("${git.password}")
    private String password;
    @Value("${git.commit-message.base}")
    private String baseMessage;
    @Value("${git.file.pattern}")
    private String filePattern;


    @Bean
    public GitManagement createGitManagement(){
        RepositoryProperties repositoryProperties = new RepositoryProperties(remoteUrl, localUri, userName, password, baseMessage, filePattern);
        return new GitManagementImpl(repositoryProperties);
    }

    @Bean
    public FileManagement createFileManagement(){
        return new FileManagementImpl(localUri);
    }
}
