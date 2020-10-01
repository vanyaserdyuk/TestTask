package ru.testtask.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;


    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Attribute> attributes;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Geometry> geometries;

    public Project(){
    }

    public Project(String name){
        this.name = name;
        this.attributes = new ArrayList<>();
        this.geometries = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            Geometry geometry = new Geometry();
            Attribute attribute = new Attribute();
            geometry.setProject(this);
            attribute.setProject(this);
            geometry.setName("geometry" + i);
            attribute.setName("attribute" + i);
            this.attributes.add(attribute);
            this.geometries.add(geometry);
        }
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
