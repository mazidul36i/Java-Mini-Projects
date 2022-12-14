package dao;

import bean.Employee;
import exceptions.EmployeeException;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> getAllEmployees() throws EmployeeException;

    public List<Employee> getEmployeesByAddress(String address) throws EmployeeException;

}