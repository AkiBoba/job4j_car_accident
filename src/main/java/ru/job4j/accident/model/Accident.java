package ru.job4j.accident.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Accident {
    private int id;
    private String name;
    private String text;
    private String address;
    private AccidentType type;
    private List<Rule> rule;

    public Accident(int id, String name, String text, String address, AccidentType type, List<Rule> rule) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.address = address;
        this.type = type;
        this.rule = rule;
    }
}
