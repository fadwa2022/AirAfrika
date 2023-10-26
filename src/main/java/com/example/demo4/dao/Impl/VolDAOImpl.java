package com.example.demo4.dao.Impl;

import com.example.demo4.connection.Jpa;
import com.example.demo4.dao.VolDAO;
import com.example.demo4.entités.Aeroports;
import com.example.demo4.entités.Vol;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class VolDAOImpl implements VolDAO {

    static EntityManager entityManager = Jpa.getInstance().getEntityManager();

    @Override
    public Vol addVol(Vol vol) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(vol);
            transaction.commit();
            return vol;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Vol updateVol(Vol vol) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Vol updatedVol = entityManager.merge(vol);
            transaction.commit();
            return updatedVol;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public void deleteVol(int volId) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Vol vol = entityManager.find(Vol.class, volId);
            if (vol != null) {
                entityManager.remove(vol);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Vol> findAllVols() {
        return entityManager.createQuery("SELECT v FROM Vol v", Vol.class).getResultList();
          }

    @Override
    public Vol findVolById(int volId) {
        return entityManager.find(Vol.class, volId);
    }
    @Override
    public List<Vol> searchVol(Aeroports aeroportArrivee, Aeroports aeroportDepart, Date dateArrivee, Date dateDepart) {
        List<Vol> vols = new ArrayList<>();

        try {
            String hql = "FROM Vol WHERE villearrivee = :arrivee AND villedepart = :depart " +
                    "AND YEAR(dateetheurearrivée) = YEAR(:dateArrivee) " +
                    "AND MONTH(dateetheurearrivée) = MONTH(:dateArrivee) " +
                    "AND DAY(dateetheurearrivée) = DAY(:dateArrivee) " +
                    "AND YEAR(dateetheurededépart) = YEAR(:dateDepart) " +
                    "AND MONTH(dateetheurededépart) = MONTH(:dateDepart) " +
                    "AND DAY(dateetheurededépart) = DAY(:dateDepart)";
            Query query = entityManager.createQuery(hql);
            query.setParameter("arrivee", aeroportArrivee);
            query.setParameter("depart", aeroportDepart);
            query.setParameter("dateArrivee", dateArrivee);
            query.setParameter("dateDepart", dateDepart);

            vols = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vols;
    }


}
