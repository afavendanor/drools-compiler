package co.com.suramericana.persistence.entity;


import co.com.suramericana.domain.Action;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Clob;
import java.sql.Date;

public class JsonRuleTest {

    @Autowired
    JsonRule jsonRule;

    @Test
    public void jsonRuleTest() {
        //Arrange
        final String id = "1";
        final String description = "Rule description";
        final int topic = 1;
        final Clob rule = null ;
        final Date date = new Date(System.currentTimeMillis());
        final String author = "author";
        final String modifiedBy = "author";
        final int voided = 0;
        final String voidedReason = "because ...";
        //Act
       jsonRule = new JsonRule();
       jsonRule.setId(id);
       jsonRule.setDescription(description);
       jsonRule.setTopic(topic);
       jsonRule.setRule(rule);
       jsonRule.setCreationDate(date);
       jsonRule.setAuthor(author);
       jsonRule.setModificationDate(date);
       jsonRule.setModifiedBy(modifiedBy);
       jsonRule.setVoided(voided);
       jsonRule.setVoidDate(date);
       jsonRule.setVoidedReason(voidedReason);
        //Assert
        Assert.assertEquals(jsonRule.getId(),id);
        Assert.assertEquals(jsonRule.getDescription(),description);
        Assert.assertEquals(jsonRule.getTopic(),topic);
        Assert.assertEquals(jsonRule.getRule(),rule);
        Assert.assertEquals(jsonRule.getCreationDate(),date);
        Assert.assertEquals(jsonRule.getAuthor(),author);
        Assert.assertEquals(jsonRule.getModificationDate(),date);
        Assert.assertEquals(jsonRule.getModifiedBy(),modifiedBy);
        Assert.assertEquals(jsonRule.getVoided(),voided);
        Assert.assertEquals(jsonRule.getVoidDate(),date);
        Assert.assertEquals(jsonRule.getVoidedReason(),voidedReason);

    }

}
