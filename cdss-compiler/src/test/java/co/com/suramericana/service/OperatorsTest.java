package co.com.suramericana.service;

import org.junit.Assert;
import org.junit.Test;

public class OperatorsTest {

    @Test
    public void getValueEqual() {
        //Arrange
        final String  equal= "igual";
        //Act
        String response = Operators.getValue(equal);
        //Assert
        Assert.assertEquals(" == ", response);
    }

    @Test
    public void getGreaterThanOperator() {
        //Arrange
        final String  equal= "mayor";
        //Act
        String response = Operators.getValue(equal);
        //Assert
        Assert.assertEquals(" > ", response);
    }

    @Test
    public void getGreaterThanOrEqualOperator() {
        //Arrange
        final String  equal= "mayor_igual";
        //Act
        String response = Operators.getValue(equal);
        //Assert
        Assert.assertEquals(" >= ", response);
    }

    @Test
    public void getLessThanOperator() {
        //Arrange
        final String  equal= "menor";
        //Act
        String response = Operators.getValue(equal);
        //Assert
        Assert.assertEquals(" < ", response);
    }

    @Test
    public void getLessThanOrEqualOperator() {
        //Arrange
        final String  equal= "menor_igual";
        //Act
        String response = Operators.getValue(equal);
        //Assert
        Assert.assertEquals(" <= ", response);
    }

    @Test
    public void getValueDoesNotHaveLessThanOperator() {
        //Arrange
        final String  equal= "no_tenga_menos";
        //Act
        String response = Operators.getValue(equal);
        //Assert
        Assert.assertEquals(" >= ", response);
    }

    @Test
    public void getValueDoesNotHaveGreaterThanOperator() {
        //Arrange
        final String  equal= "no_tenga_mayor";
        //Act
        String response = Operators.getValue(equal);
        //Assert
        Assert.assertEquals(" <= ", response);
    }
}