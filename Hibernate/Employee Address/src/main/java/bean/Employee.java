package bean;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empID;
    private String name;
    private String gender;
    private int salary;

    @ElementCollection
    @Embedded
    @JoinTable(name = "EmployeeAddress", joinColumns = @JoinColumn(name = "empID"))
    private Set<Address> empAddress = new HashSet();

    public Employee() {
    }

    public Employee(int empID, String name, String gender, int salary, Set<Address> empAddress) {
        this.empID = empID;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.empAddress = empAddress;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Set<Address> getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(Set<Address> empAddress) {
        this.empAddress = empAddress;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empID=" + empID +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", empAddress=" + empAddress +
                '}';
    }
}
