package dao;

import bean.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmployeeDaoImpl implements EmployeeDao {

    static EntityManager em;

    static {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Employee");
        em = emf.createEntityManager();
    }

    @Override
    public void save(Employee emp) {
        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();

        System.out.println("Employee saved successfully!");
        em.close();
    }

    @Override
    public String getAddressOfEmployee(int empId) {
        Employee employee = em.find(Employee.class, empId);

        em.close();
        if (employee != null) {
            return employee.getAddress();
        } else {
            return "No employee found with empId: " + empId;
        }
    }

    @Override
    public String giveBonusToEmployee(int empId, int bonus) {
        Employee employee = em.find(Employee.class, empId);

        if (employee != null) {
            em.getTransaction().begin();
            employee.setSalary(employee.getSalary() + bonus);
            em.getTransaction().commit();
            em.close();
            return "Bonus given to employee with empId: " + empId + " successfully";
        }

        em.close();
        return "No employee found with empId: " + empId;
    }

    @Override
    public boolean deleteEmployee(int empId) {
        Employee employee = em.find(Employee.class, empId);

        if (employee != null) {
            em.getTransaction().begin();
            em.remove(employee);
            em.getTransaction().commit();
            em.close();
            return true;
        }

        em.close();
        return false;
    }
}
