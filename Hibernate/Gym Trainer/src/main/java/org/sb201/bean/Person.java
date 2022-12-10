package org.sb201.bean;

import javax.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private int person_id;
    private String name;
    private String email, mobile;

    @OneToMany
    @JoinColumn(name = "gym_id")
    private Gym gym;

    public Person() {
    }

    public Person(int person_id, String name, String email, String mobile) {
        this.person_id = person_id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Person{" +
                "person_id=" + person_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
