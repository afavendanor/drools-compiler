package co.com.suramericana.exception;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ResponseErrorTest {

    @Autowired
    ResponseError responseError;

    @Test
    public void responseErrorTest() {
        //Arrange
        final int code = 400;
        final String message = "Bad Request";
        //Act
        responseError = new ResponseError(code, message);
        //Assert
        Assert.assertEquals(responseError.getCode(), code);
        Assert.assertEquals(responseError.getMessage(), message);
    }
}
