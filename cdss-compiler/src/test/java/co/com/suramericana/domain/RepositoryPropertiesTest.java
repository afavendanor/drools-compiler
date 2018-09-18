package co.com.suramericana.domain;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

public class RepositoryPropertiesTest {

    @Autowired
    RepositoryProperties repositoryProperties;

    @Test
    public void repositoryPropertiesTest() {
        //Arrange
        final String remoteUrl = "http://repo.com/myrepo";
        final String localUri = "src/main/repo";
        final String userName = "user";
        final String passwordCoded = "mTBpbZlrFlB111Vfz9KurQ&&k2f4LpUFHtiiUq60heW7JE25+Oin2xAvDRCzNcoS3A4";
        final String passwordDecoded = "S3CR4T";
        final String baseMessage = "Commit message";
        final String filePattern = ".";
        //Act
        repositoryProperties = new RepositoryProperties(remoteUrl,localUri,userName,passwordCoded,baseMessage,filePattern);
        //Assert
        Assert.assertEquals(repositoryProperties.getRemoteUrl(),remoteUrl);
        Assert.assertEquals(repositoryProperties.getLocalUri(),localUri);
        Assert.assertEquals(repositoryProperties.getUserName(),userName);
        Assert.assertEquals(repositoryProperties.getPassword(),passwordDecoded);
        Assert.assertEquals(repositoryProperties.getBaseMessage(),baseMessage);
        Assert.assertEquals(repositoryProperties.getFilePattern(),filePattern);
        Assert.assertNotNull(repositoryProperties.getCredentials());
        Assert.assertNotNull(repositoryProperties.getLocalRepository());
    }
}
