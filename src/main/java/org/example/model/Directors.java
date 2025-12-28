package org.example.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Directors")
public class Directors {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "owner")
    private List<Films> films;

    public Directors() {

    }

    public Directors(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Films> getFilms() {
        return films;
    }

    public void setFilms(List<Films> films) {
        this.films = films;
    }

    @Override
    public String toString() {
        return "Directors{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
