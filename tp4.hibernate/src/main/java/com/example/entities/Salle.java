package com.example.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "salles")
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String code;

    @OneToMany(mappedBy = "salle", fetch = FetchType.EAGER)
    private List<Machine> machines = new ArrayList<>();

    // ===== Constructeurs =====

    public Salle() {
    }

    public Salle(String code) {
        this.code = code;
    }

    // ===== Getters / Setters =====

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

    @Override
    public String toString() {
        return "Salle{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", machines=" + machines.size() +
                '}';
    }
}
