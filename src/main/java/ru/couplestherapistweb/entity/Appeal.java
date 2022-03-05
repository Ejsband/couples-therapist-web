package ru.couplestherapistweb.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "appeals")
public class Appeal {

    @Id
    private String id;
    private String name;
    private String phone;
    private String email;
    private String text;
    private LocalDateTime date;

    public Appeal() {
    }

    public Appeal(String id, String name, String phone, String email, String text, LocalDateTime date) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.text = text;
        this.date = date;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
