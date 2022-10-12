package ru.couplestherapistweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "appeals")
@Getter
@Setter
@NoArgsConstructor
public class Appeal {

    @Id
    private String id;
    private String name;
    private String phone;
    private String email;
    private String text;
    private LocalDateTime date;

    public Appeal(String id, String name, String phone, String email, String text, LocalDateTime date) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.text = text;
        this.date = date;
    }
}
