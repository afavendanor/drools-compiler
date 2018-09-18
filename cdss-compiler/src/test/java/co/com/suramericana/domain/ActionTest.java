package co.com.suramericana.domain;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ActionTest {

    @Autowired
    Action action;

    @Test
    public void actionTest() {
        //Arrange
        final String type = "alert";
        final String description = "this is an alert!";
        //Act
        action = new Action(type, description);
        //Assert
        Assert.assertEquals(action.getType(),type);
        Assert.assertEquals(action.getDescription(),description);
        Assert.assertEquals(action.toString(),type+description);
    }

}
