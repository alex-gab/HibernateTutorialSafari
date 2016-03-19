package com.infiniteskills.data;

import com.infiniteskills.data.entities.User;
import org.hibernate.Session;

import java.util.Date;


public class Application {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.getTransaction().begin();
        User user = new User();
        user.setBirthDate(new Date());
        user.setCreatedBy("kevin");
        user.setCreatedDate(new Date());
        user.setEmailAddress("kmb385@yahoo.com");
        user.setFirstName("Maria");
        user.setLastName("Fintesteanu");
        user.setLastUpdatedBy("kevin");
        user.setLastUpdatedDate(new Date());
        session.save(user);
        session.getTransaction().commit();

//        session.beginTransaction();
//        final User lastUser = session.get(User.class, user.getUserId());
//        user.setFirstName("Joe");
//        session.update(lastUser);
//        session.getTransaction().commit();

        session.close();
    }
}
