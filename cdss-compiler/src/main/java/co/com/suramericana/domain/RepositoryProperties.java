package co.com.suramericana.domain;

import co.com.suramericana.security.Encryptor;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;

public class RepositoryProperties {

    private String remoteUrl;
    private String localUri;
    private String userName;
    private String password;
    private String baseMessage;
    private String filePattern;
    private UsernamePasswordCredentialsProvider credentials;
    private File localRepository;

    public RepositoryProperties(String remoteUrl, String localUri, String userName,
                                String password, String baseMessage, String filePattern) {
        this.remoteUrl = remoteUrl;
        this.localUri = localUri;
        this.userName = userName;
        this.password = password;
        this.baseMessage = baseMessage;
        this.filePattern = filePattern;
        this.credentials = new UsernamePasswordCredentialsProvider(userName,Encryptor.decode(password)) ;
        this.localRepository = new File(localUri);
    }

    public String getRemoteUrl() {
        return remoteUrl;
    }

    public String getLocalUri() {
        return localUri;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return Encryptor.decode(password);
    }

    public String getBaseMessage() {
        return baseMessage;
    }

    public String getFilePattern() {
        return filePattern;
    }

    public UsernamePasswordCredentialsProvider getCredentials() {
        return credentials;
    }

    public File getLocalRepository() {
        return localRepository;
    }

}
