package com.infiniteskills.data;

import com.infiniteskills.data.entities.Bank;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;


public class Application {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Bank bank = new Bank();
            bank.setName("Rom Trust");
            bank.setAddressLine1("line 1");
            bank.setAddressLine2("line2");
            bank.setCity("Philadelphia");
            bank.setState("PA");
            bank.setZipCode("12345");
            bank.setCreatedBy("Kevin");
            bank.setCreatedDate(new Date());
            bank.setLastUpdatedBy("kmb");
            bank.setLastUpdatedDate(new Date());
            bank.setInternational(false);

            bank.addContact("MANAGER", "Joe");
            bank.addContact("TELLER", "Mary");

            session.save(bank);

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.getSessionFactory().close();
        }
    }
}
