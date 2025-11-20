package com.example.tests;

import com.example.entities.Machine;
import com.example.entities.Salle;
import com.example.services.MachineService;
import com.example.services.SalleService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class MachineServiceTest {

    private MachineService machineService;
    private Machine machine;
    private Salle salle;
    private SalleService salleService;

    @Before
    public void setUp() {
        machineService = new MachineService();
        salleService = new SalleService();

        // Persister une salle avant les tests
        salle = new Salle("A101");
        salleService.create(salle);

        // Créer et persister une machine liée à cette salle
        machine = new Machine();
        machine.setRef("MACH-001");
        machine.setDateAchat(new Date());
        machine.setSalle(salle);

        machineService.create(machine);
    }

    @After
    public void tearDown() {
        // Supprimer la machine
        Machine foundMachine = machineService.findById(machine.getId());
        if (foundMachine != null) {
            machineService.delete(foundMachine);
        }

        // Supprimer la salle
        Salle foundSalle = salleService.findById(salle.getId());
        if (foundSalle != null) {
            salleService.delete(foundSalle);
        }
    }

    @Test
    public void testCreate() {
        assertTrue("L'id de la machine doit être > 0", machine.getId() > 0);
    }

    @Test
    public void testFindById() {
        Machine foundMachine = machineService.findById(machine.getId());
        assertNotNull("La machine doit être trouvée", foundMachine);
        assertEquals("La référence doit correspondre",
                machine.getRef(), foundMachine.getRef());
    }

    @Test
    public void testUpdate() {
        machine.setRef("MACH-002");
        boolean result = machineService.update(machine);
        assertTrue("La mise à jour doit réussir", result);

        Machine updatedMachine = machineService.findById(machine.getId());
        assertEquals("La nouvelle référence doit être MACH-002",
                "MACH-002", updatedMachine.getRef());
    }

    @Test
    public void testDelete() {
        boolean result = machineService.delete(machine);
        assertTrue("La suppression doit réussir", result);

        Machine foundMachine = machineService.findById(machine.getId());
        assertNull("La machine ne doit plus exister", foundMachine);
    }

    @Test
    public void testFindBetweenDate() {
        // Hier
        Date d1 = new Date(System.currentTimeMillis() - 86400000L);
        // Aujourd'hui
        Date d2 = new Date();

        List<Machine> machines = machineService.findBetweenDate(d1, d2);
        assertNotNull("La liste ne doit pas être nulle", machines);
        assertTrue("La liste doit contenir au moins une machine",
                machines.size() > 0);
    }
}
