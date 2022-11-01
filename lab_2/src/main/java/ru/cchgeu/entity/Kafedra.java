package ru.cchgeu.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
public class Kafedra {

    private int id;
    private String name;
    private String fone;
    private String address;
    private int age;

    public Kafedra(HashMap<String, Object> item) {
        id = (int) item.get("id");
        name = (String) item.get("name");
        fone = (String) item.get("fone");
        address = (String) item.get("address");
        age = (int) item.get("age");

    }
}
