package usecases;

import bean.Address;
import bean.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Employee");
        EntityManager manager = emf.createEntityManager();

//      Employee 1
        {
            Employee e1 = new Employee();
            e1.setName("Chunnu");
            e1.setGender("male");
            e1.setSalary(1000);

            Address a1 = new Address();
            a1.setCity("Pune");
            a1.setPincode("125343");
            a1.setState("Mumbai");
            a1.setType("Home");

            Address a2 = new Address();
            a2.setCity("Barpeta Road");
            a2.setPincode("781313");
            a2.setState("Assam");
            a2.setType("Office");

            Set<Address> e1a = new HashSet<>();
            e1a.add(a1);
            e1a.add(a2);

            e1.setEmpAddress(e1a);

            manager.getTransaction().begin();
            manager.persist(e1);
            manager.getTransaction().commit();
        }
//      Employee 2
        {
            Employee e1 = new Employee();
            e1.setName("Munnu");
            e1.setGender("male");
            e1.setSalary(10000);

            Address a1 = new Address();
            a1.setCity("Pune");
            a1.setPincode("3214");
            a1.setState("Mumbai");
            a1.setType("Home");

            Address a2 = new Address();
            a2.setCity("Ghy");
            a2.setPincode("781001");
            a2.setState("Assam");
            a2.setType("Office");

            Set<Address> e1a = new HashSet<>();
            e1a.add(a1);
            e1a.add(a2);

            e1.setEmpAddress(e1a);

            manager.getTransaction().begin();
            manager.persist(e1);
            manager.getTransaction().commit();
        }
//      Employee 3
        {
            Employee e1 = new Employee();
            e1.setName("Pablo");
            e1.setGender("male");
            e1.setSalary(534553);

            Address a1 = new Address();
            a1.setCity("New Delhi");
            a1.setPincode("758435");
            a1.setState("Delhi");
            a1.setType("Home");

            Address a2 = new Address();
            a2.setCity("Delhi");
            a2.setPincode("346782");
            a2.setState("Delhi");
            a2.setType("Office");

            Set<Address> e1a = new HashSet<>();
            e1a.add(a1);
            e1a.add(a2);

            e1.setEmpAddress(e1a);

            manager.getTransaction().begin();
            manager.persist(e1);
            manager.getTransaction().commit();
        }
//      Employee 4
        {
            Employee e1 = new Employee();
            e1.setName("Panday");
            e1.setGender("male");
            e1.setSalary(54835);

            Address a1 = new Address();
            a1.setCity("Pune");
            a1.setPincode("125343");
            a1.setState("Mumbai");
            a1.setType("Home");

            Address a2 = new Address();
            a2.setCity("Barpeta Road");
            a2.setPincode("781313");
            a2.setState("Assam");
            a2.setType("Office");

            Set<Address> e1a = new HashSet<>();
            e1a.add(a1);
            e1a.add(a2);

            e1.setEmpAddress(e1a);

            manager.getTransaction().begin();
            manager.persist(e1);
            manager.getTransaction().commit();
        }


//        Getting Employee 3
        manager.getTransaction().begin();
        Employee employee = manager.find(Employee.class, 3);
        System.out.println("=======================================================");
        System.out.println(employee);

        manager.close();
    }

}
