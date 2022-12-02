package usecases;

import bean.PhoneNumber;
import bean.User;
import exceptions.UserException;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("User");
    static EntityManager manager = emf.createEntityManager();

    public static void main(String[] args) {

        {
            manager.getTransaction().begin();

            User user1 = new User();
            user1.setUserName("Nrupul");
            user1.setEmailid("nrupul@masaischol.com");

            manager.persist(user1);

            Set<PhoneNumber> phoneNumbers = new HashSet<>();
            phoneNumbers.add(new PhoneNumber(1, "4738294725", "Home"));
            phoneNumbers.add(new PhoneNumber(2, "537483", "Landline"));
            phoneNumbers.add(new PhoneNumber(3, "5473895654", "Office"));

            user1.setPhoneNumbers(phoneNumbers);
            manager.getTransaction().commit();
        }
        {
            manager.getTransaction().begin();

            User user2 = new User();
            user2.setUserName("Prateek");
            user2.setEmailid("prateek@masaischol.com");

            manager.persist(user2);

            Set<PhoneNumber> phoneNumbers = new HashSet<>();
            phoneNumbers.add(new PhoneNumber(4, "758394574", "Home"));
            phoneNumbers.add(new PhoneNumber(5, "463278", "Landline"));
            phoneNumbers.add(new PhoneNumber(6, "859375345", "Office"));

            user2.setPhoneNumbers(phoneNumbers);
            manager.getTransaction().commit();
        }


        System.out.println("===============================");

        try {
            Set<PhoneNumber> ps1 = getPhoneList("Nrupul");

            ps1.forEach(System.out::println);

        } catch (UserException e) {
            System.out.println(e.getMessage());
        }

        try {
            Set<PhoneNumber> ps2 = getPhoneList("Albert");

            ps2.forEach(System.out::println);

        } catch (UserException e) {
            System.out.println(e.getMessage());
        }

        manager.close();
    }

    static Set<PhoneNumber> getPhoneList(String name) throws UserException {

        Query query = manager.createQuery("FROM User WHERE userName= :name");
        query.setParameter("name", name);

        try {
            User user = (User) query.getSingleResult();
            if (user == null) throw new UserException("User not found!");

            return user.getPhoneNumbers();
        } catch (NoResultException e) {
            throw new UserException("User not found!");
        }

    }

}
