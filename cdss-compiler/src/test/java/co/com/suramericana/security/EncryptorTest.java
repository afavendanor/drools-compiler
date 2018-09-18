package co.com.suramericana.security;


import co.com.suramericana.exception.TechnicalException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EncryptorTest {

    @Test
    public void encodeTest() {
        //Arrange
        final String secret = "D3S4RR0LL0CDS";
        final int encodeLenght = 67;
        //Act
        final String encodedResult = Encryptor.encode(secret);
        //Assert
        assertNotNull(encodedResult);
        assertEquals(encodedResult.length(),encodeLenght);
    }

    @Test
    public void decodeTest() {
        //Arrange
        final String secret = "S3CR4T";
        final String encryptedSecret = "mTBpbZlrFlB111Vfz9KurQ&&k2f4LpUFHtiiUq60heW7JE25+Oin2xAvDRCzNcoS3A4";
        //Act
        final String decodedResult = Encryptor.decode(encryptedSecret);
        //Assert
        assertEquals(decodedResult, secret);
    }

    @Test(expected = TechnicalException.class)
    public void decodeExceptionTest() {
        //Arrange
        final String encryptedSecret = "mTBpbZlrFlB111Vfz9KurQ&&k2f4LpUFHtiiUq60heW7JE25+Oin2xAvDRCzNcoS3A4123";
        //Act
        final String decodedResult = Encryptor.decode(encryptedSecret);
    }

}
