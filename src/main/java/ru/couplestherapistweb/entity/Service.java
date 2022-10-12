package ru.couplestherapistweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service")
@Getter
@Setter
@NoArgsConstructor
public class Service {

    @Id
    private String id;
    private String name;
    private Integer price;
    private Integer duration;
}
