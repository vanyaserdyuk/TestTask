package ru.testtask.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "geometries")
public class Geometry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;


    private String name;

    public Geometry(){

    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void setName(String name) {
        this.name = name;
    }
}
