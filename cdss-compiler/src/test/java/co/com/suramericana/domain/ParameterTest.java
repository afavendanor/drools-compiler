package co.com.suramericana.domain;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ParameterTest {

    @Autowired
    Parameter parameter;

    @Test
    public void repositoryPropertiesTest() {
        //Arrange
        final String codeRule = "ITU0001";
        final String conditionsList = "1,2,3,4,5";
        final String conditionType = "condition";
        final String actions = "take a pill";
        final String firstRow = "true";
        //Act
            parameter = new Parameter(codeRule, conditionsList, conditionType, actions, firstRow);
        //Assert
        Assert.assertEquals(parameter.getCodeRule(),codeRule);
        Assert.assertEquals(parameter.getConditionsList(),conditionsList);
        Assert.assertEquals(parameter.getConditionType(),conditionType);
        Assert.assertEquals(parameter.getActions(),actions);
        Assert.assertEquals(parameter.getFirstRow(),firstRow);

    }
}
