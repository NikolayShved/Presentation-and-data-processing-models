package ru.cchgeu.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class Kafedra implements Serializable {

    private int id;
    private String name;
    private String fone;
    private String address;
    private int age;
}
