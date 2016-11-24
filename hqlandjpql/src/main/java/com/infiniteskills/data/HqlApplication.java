package com.infiniteskills.data;

import com.infiniteskills.data.entities.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public final class HqlApplication {
    public static void main(String[] args) {
        org.hibernate.Transaction tx = null;

        try (SessionFactory factory = HibernateUtil.getSessionFactory();
             Session session = factory.openSession()) {
            tx = session.beginTransaction();

            final Query<Transaction> query = session.createQuery(
                    "select t from Transaction t " +
                            "where (t.amount between 75 and 100) and t.title like '%s'",
                    Transaction.class);
            final List<Transaction> transactions = query.list();
            for (Transaction t : transactions) {
                System.out.println(t.getTitle());
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }
}
