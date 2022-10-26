package ru.couplestherapistweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "data")
@Getter
@Setter
@NoArgsConstructor
public class Data {

    @Id
    private String id;
    private String name;
    private String value;
}
