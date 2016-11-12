package com.infiniteskills.data;

import com.infiniteskills.data.entities.Credential;
import com.infiniteskills.data.entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;


public class Application {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            User user = new User();
            user.setFirstName("Kevin");
            user.setLastName("Bowersox");
            user.setAge(20);
            user.setBirthDate(new Date());
            user.setCreatedBy("Kevin Bowersox");
            user.setCreatedDate(new Date());
            user.setEmailAddress("kevin.bowersox@navy.mil");
            user.setLastUpdatedDate(new Date());
            user.setLastUpdatedBy("Kevin Bowersox");

            Credential credential = new Credential();
            credential.setPassword("kevinspassword");
            credential.setUsername("kmb385");
            credential.setUser(user);

            session.save(credential);
            transaction.commit();

            final User dbUser = session.get(User.class, credential.getUser().getUserId());
            System.out.println(dbUser.getFirstName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.getSessionFactory().close();
        }
    }
}
