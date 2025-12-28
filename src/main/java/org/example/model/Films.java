package org.example.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Films")
public class Films {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;


    @ManyToOne
    @JoinColumn(name = "director_id", referencedColumnName = "id")
    private Directors owner;


    public Films(){

    }

    public Films(String title, Directors owner) {
        this.title = title;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = (long) id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Directors getOwner() {
        return owner;
    }

    public void setOwner(Directors owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Films{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", owner=" + owner +
                '}';
    }
}

