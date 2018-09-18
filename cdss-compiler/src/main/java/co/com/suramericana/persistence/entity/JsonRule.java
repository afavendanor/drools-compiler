package co.com.suramericana.persistence.entity;

import javax.persistence.*;
import java.sql.Clob;
import java.sql.Date;

@Entity
@Table(name = "TCDS_JSON_RULES_L01")
public class JsonRule {

    @Id
    @Column(name="cdrule")
    private String id;

    @Column(name="dsrule")
    private String description;

    @Column(name="nmtopic")
    private int topic;

    @Column(name="dsjsrule")
    private Clob rule;

    @Column(name="fecreated")
    private Date creationDate;

    @Column(name="dscreatedBy")
    private String author;

    @Column(name="femodified")
    private Date modificationDate;

    @Column(name="dsmodifiedBy")
    private String modifiedBy;

    @Column(name="nmvoided")
    private int voided;

    @Column(name="fevoided")
    private Date voidDate;

    @Column(name="dsvoidedReason")
    private String voidedReason;

    protected JsonRule() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTopic() {
        return topic;
    }

    public void setTopic(int topic) {
        this.topic = topic;
    }

    public Clob getRule() {
        return rule;
    }

    public void setRule(Clob rule) {
        this.rule = rule;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public int getVoided() {
        return voided;
    }

    public void setVoided(int voided) {
        this.voided = voided;
    }

    public Date getVoidDate() {
        return voidDate;
    }

    public void setVoidDate(Date voidDate) {
        this.voidDate = voidDate;
    }

    public String getVoidedReason() {
        return voidedReason;
    }

    public void setVoidedReason(String voidedReason) {
        this.voidedReason = voidedReason;
    }
}
