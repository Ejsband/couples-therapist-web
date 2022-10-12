package ru.couplestherapistweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mail_user_settings")
@Getter
@Setter
@NoArgsConstructor
public class MailUser {

    @Id
    String id;
    String name;
    String sender;
    String receiver;
    String subject;
}
