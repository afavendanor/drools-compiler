package co.com.suramericana.exception;

import org.junit.Assert;
import org.junit.Test;

public class DomainExceptionTest {

    @Test
    public void domainExceptionTest() {
        //Arrange
        final String exceptionMessage = "Domain exception";
        //Act
        DomainException domainException = new DomainException(exceptionMessage);
        //Assert
        Assert.assertNotNull(domainException);
        Assert.assertEquals(domainException.getMessage(), exceptionMessage);
    }
}