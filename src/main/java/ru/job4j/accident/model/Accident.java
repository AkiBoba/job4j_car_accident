package ru.job4j.accident.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Accident {
    private int id;
    private String name;
    private String text;
    private String address;

    public Accident(int id, String name, String text, String address) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.address = address;
    }
}
