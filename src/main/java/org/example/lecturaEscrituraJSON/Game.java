package org.example.lecturaEscrituraJSON;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Game implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String description;
    private List<String> languages = new ArrayList<>();

    public Game(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public List<String> getLanguages() {
        return languages;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void addLanguages(String language) {
        this.languages.add(language);
    }
}
