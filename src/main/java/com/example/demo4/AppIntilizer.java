package com.example.demo4;

import com.example.demo4.connection.Jpa;
import com.example.demo4.entités.Aeroports;
import com.example.demo4.entités.Client;
import com.example.demo4.entités.Vol;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppIntilizer {


    public  static void  main(String args []){


     //


    }


    public static Aeroports getAeroportsById(int aeroportsId) {
        Aeroports aeroports = null;
        EntityManager em = Jpa.getInstance().getEntityManager();

        try{
            em.getTransaction().begin();

          //aeroports = em.find(Aeroports.class,aeroportsId);
            aeroports = new Aeroports("hi","hi");
          em.persist(aeroports);

            em.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.toString());

            em.getTransaction().rollback();



        }

//        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//                aeroports = session.get(Aeroports.class, aeroportsId);
//
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction !=null){
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
        return aeroports;
    }
        static EntityManager entityManager = Jpa.getInstance().getEntityManager();

    public static List<Vol> findAllVols() {
        List<Vol> vols = null;
        try {
            vols = entityManager.createQuery("SELECT v FROM Vol v", Vol.class).getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return vols;

    }
    public static Vol findVolById(int volId) {
        return entityManager.find(Vol.class, volId);
    }
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
