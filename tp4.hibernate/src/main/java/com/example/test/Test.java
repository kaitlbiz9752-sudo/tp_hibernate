package com.example.test;

import com.example.entities.Machine;
import com.example.entities.Salle;
import com.example.services.MachineService;
import com.example.services.SalleService;

import java.util.Date;

public class Test {
    public static void main(String[] args) {

        SalleService salleService = new SalleService();
        MachineService machineService = new MachineService();

        // ===== Création de salles =====
        Salle s1 = new Salle("A1");
        Salle s2 = new Salle("B2");
        Salle s3 = new Salle("C3");

        salleService.create(s1);
        salleService.create(s2);
        salleService.create(s3);

        // ===== Création de machines =====
        Machine m1 = new Machine("M123", new Date(), s1);
        Machine m2 = new Machine("M124", new Date(), s1);
        Machine m3 = new Machine("M200", new Date(), s2);

        machineService.create(m1);
        machineService.create(m2);
        machineService.create(m3);

        System.out.println("Insertion terminée !");
    }
}
