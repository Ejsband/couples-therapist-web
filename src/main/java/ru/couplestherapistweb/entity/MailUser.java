package ru.couplestherapistweb.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mail_user_settings")
public class MailUser {

    @Id
    String id;
    String name;
    String sender;
    String receiver;
    String subject;

    public MailUser() {
    }

    public MailUser(String id, String name, String sender, String receiver, String subject) {
        this.id = id;
        this.name = name;
        this.sender = sender;
        this.receiver = receiver;
        this.subject = subject;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
