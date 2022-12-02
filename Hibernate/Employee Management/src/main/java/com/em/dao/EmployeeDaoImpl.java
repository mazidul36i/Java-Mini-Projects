package com.em.dao;

import com.em.bean.Employee;
import com.em.exceptions.EmployeeException;

import javax.persistence.*;

public class EmployeeDaoImpl implements EmployeeDao {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Employee");
    private static final EntityManager em = entityManagerFactory.createEntityManager();


    @Override
    public Employee registerEmployee(Employee employee) throws EmployeeException {
        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();

        em.close();
        return employee;
    }

    @Override
    public Employee getEmployeeById(int empId) throws EmployeeException {

        Query query = em.createQuery("FROM Employee e WHERE empId= :id");
        query.setParameter("id", empId);

        Employee employee;
        try {
            employee = (Employee) query.getSingleResult();
        } catch (NoResultException e) {
            throw  new EmployeeException("Employee doesn't found with id: " + empId + "!");
        }
        em.close();
        return employee;
    }

    @Override
    public Employee deleteEmployeeById(int empId) throws EmployeeException {
        Query query = em.createQuery("FROM Employee e WHERE empId= :id");
        query.setParameter("id", empId);

        Employee employee;
        try {
            employee = (Employee) query.getSingleResult();
        } catch (NoResultException e) {
            throw  new EmployeeException("Employee doesn't found with id: " + empId + "!");
        }

        Query query2 = em.createQuery("Delete from Employee e WHERE e.empId= :id");
        query2.setParameter("id", empId);

        em.getTransaction().begin();
        int x  = query2.executeUpdate();
        em.getTransaction().commit();
        em.close();
        if (x > 0)
            return employee;
        else throw new EmployeeException("Failed to delete employee");
    }

    @Override
    public Employee updateEmployee(Employee employee) throws EmployeeException {
        Employee employee1;

        Query query = em.createQuery("FROM Employee e WHERE empId= :id");
        query.setParameter("id", employee.getEmpId());

        try {
            employee1 = (Employee) query.getSingleResult();
        } catch (NoResultException e) {
            throw  new EmployeeException("Employee doesn't found with id: " + employee.getEmpId() + "!");
        }

        if (employee.getName() != null) {
            employee1.setName(employee.getName());
        }
        if (employee.getAddress() != null) {
            employee1.setAddress(employee.getAddress());
        }
        if (employee.getSalary() != -1) {
            employee1.setSalary(employee.getSalary());
        }

        Query query1 = em.createQuery("Update Employee e set e.name= :name, e.address = :address, e.salary = :salary");
        query1.setParameter("name", employee1.getName());
        query1.setParameter("address", employee1.getAddress());
        query1.setParameter("salary", employee1.getSalary());

        em.getTransaction().begin();
        int x = query1.executeUpdate();
        em.getTransaction().commit();
        em.close();

        if (x > 0)
            return employee1;
        else throw new EmployeeException("Failed to update employee details!");
    }
}
