package com.infiniteskills.data;

import com.infiniteskills.data.entities.Transaction;

import javax.persistence.*;
import java.util.List;

public final class JpqlApplication {
    public static void main(String[] args) {
        EntityManagerFactory factory = null;
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            factory = Persistence.createEntityManagerFactory("infinite-finances");
            em = factory.createEntityManager();

            tx = em.getTransaction();
            tx.begin();

            final TypedQuery<Transaction> query =
                    em.createQuery(
                            "select t from Transaction t " +
                                    "where (t.amount between 75 and 100) and t.title like '%s'",
                            Transaction.class);
            final List<Transaction> transactions = query.getResultList();
            for (Transaction t : transactions) {
                System.out.println(t.getTitle());
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            if (em != null) {
                em.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
    }
}
