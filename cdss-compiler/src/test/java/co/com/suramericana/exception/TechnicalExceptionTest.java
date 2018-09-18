package co.com.suramericana.exception;

import org.junit.Assert;
import org.junit.Test;

public class TechnicalExceptionTest {

    @Test
    public void technicalExceptionTest() {
        //Arrange
        final String exceptionMessage = "Technical exception";
        //Act
        TechnicalException technicalException = new TechnicalException(exceptionMessage);
        //Assert
        Assert.assertNotNull(technicalException);
        Assert.assertEquals(technicalException.getMessage(),exceptionMessage);
    }

    @Test
    public void technicalExceptionThrowableTest() {
        //Arrange
        final String exceptionMessage = "Technical exception";
        final Throwable exception = new Exception();
        //Act
        TechnicalException technicalException = new TechnicalException(exceptionMessage, exception);
        //Assert
        Assert.assertNotNull(technicalException);
        Assert.assertEquals(technicalException.getMessage(),exceptionMessage);
        Assert.assertEquals(technicalException.getCause(),exception);
    }
}