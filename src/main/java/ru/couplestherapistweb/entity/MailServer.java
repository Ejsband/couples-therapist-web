package ru.couplestherapistweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mail_server_settings")
@Getter
@Setter
@NoArgsConstructor
public class MailServer {

    @Id
    String id;
    String name;
    String host;
    Integer port;
    String username;
    String password;
}
