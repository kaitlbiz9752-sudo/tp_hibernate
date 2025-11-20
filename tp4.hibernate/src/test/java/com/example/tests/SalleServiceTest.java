package com.example.tests;

import com.example.entities.Salle;
import com.example.services.SalleService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SalleServiceTest {

    private SalleService salleService;
    private Salle salle;

    @Before
    public void setUp() {
        salleService = new SalleService();
        salle = new Salle();
        salle.setCode("A101");

        // Créer et persister la salle avant chaque test
        salleService.create(salle);
    }

    @After
    public void tearDown() {
        // Supprimer la salle après chaque test si elle existe
        Salle foundSalle = salleService.findById(salle.getId());
        if (foundSalle != null) {
            salleService.delete(foundSalle);
        }
    }

    @Test
    public void testCreate() {
        // Après create(), l'id doit être généré
        assertTrue("L'id de la salle doit être > 0", salle.getId() > 0);
    }

    @Test
    public void testFindById() {
        Salle foundSalle = salleService.findById(salle.getId());
        assertNotNull("La salle doit être trouvée", foundSalle);
        assertEquals("Le code de la salle doit correspondre",
                salle.getCode(), foundSalle.getCode());
    }

    @Test
    public void testUpdate() {
        salle.setCode("B202");
        boolean result = salleService.update(salle);
        assertTrue("La mise à jour doit réussir", result);

        Salle updatedSalle = salleService.findById(salle.getId());
        assertEquals("Le nouveau code doit être B202",
                "B202", updatedSalle.getCode());
    }

    @Test
    public void testDelete() {
        boolean result = salleService.delete(salle);
        assertTrue("La suppression doit réussir", result);

        Salle foundSalle = salleService.findById(salle.getId());
        assertNull("La salle ne doit plus exister", foundSalle);
    }

    @Test
    public void testFindAll() {
        List<Salle> salles = salleService.findAll();
        assertNotNull("La liste ne doit pas être nulle", salles);
        assertTrue("La liste doit contenir au moins une salle", salles.size() > 0);
    }
}
