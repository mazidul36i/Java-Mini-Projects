package dao;

import bean.Employee;
import exceptions.EmployeeException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Employee");
    static EntityManager manager = emf.createEntityManager();

    @Override
    public List<Employee> getAllEmployees() throws EmployeeException {
        manager.getTransaction().begin();
        Query query = manager.createQuery("From Employee");
        List<Employee> employees = (List<Employee>) query.getResultList();
        manager.getTransaction().commit();
        manager.close();
        if (employees.size() > 0)
            return employees;
        else
            throw new EmployeeException("No employee found to be load!");
    }

    @Override
    public List<Employee> getEmployeesByAddress(String address) throws EmployeeException {
        manager.getTransaction().begin();
        Query query = manager.createQuery("From Employee e WHERE e.address = :address");
        query.setParameter("address", address);
        List<Employee> employees = (List<Employee>) query.getResultList();
        manager.getTransaction().commit();
        manager.close();

        if (employees.size() > 0)
            return employees;
        else
            throw new EmployeeException("No employee found with the given address!");
    }

}
