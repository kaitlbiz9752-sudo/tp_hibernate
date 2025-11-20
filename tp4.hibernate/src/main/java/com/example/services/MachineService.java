package com.example.services;

import com.example.dao.IDao;
import com.example.entities.Machine;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

public class MachineService implements IDao<Machine> {

    @Override
    public boolean create(Machine o) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Machine o) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Machine o) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Machine findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Machine.class, id);
        }
    }

    @Override
    public List<Machine> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Machine", Machine.class).list();
        }
    }

    // ===== Méthode spécifique de ton TP =====
    public List<Machine> findBetweenDate(Date d1, Date d2) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // On utilise la @NamedQuery "findBetweenDate" définie dans l'entité Machine
            return session.createNamedQuery("findBetweenDate", Machine.class)
                    .setParameter("d1", d1)
                    .setParameter("d2", d2)
                    .getResultList();
        }
    }
}
