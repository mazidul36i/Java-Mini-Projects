package org.sb201.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Gym {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int gym_id;
    private String gym_name;
    private int monthly_fee;

    private int trainer_id;

    @ElementCollection
    @OneToMany
    private List<Person> persons;

    public Gym() {
    }

    public Gym(int gym_id, String gym_name, int monthly_fee) {
        this.gym_id = gym_id;
        this.gym_name = gym_name;
        this.monthly_fee = monthly_fee;
    }

    public int getTrainer_id() {
        return trainer_id;
    }

    public void setTrainer_id(int trainer_id) {
        this.trainer_id = trainer_id;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public int getGym_id() {
        return gym_id;
    }

    public void setGym_id(int gym_id) {
        this.gym_id = gym_id;
    }

    public String getGym_name() {
        return gym_name;
    }

    public void setGym_name(String gym_name) {
        this.gym_name = gym_name;
    }

    public int getMonthly_fee() {
        return monthly_fee;
    }

    public void setMonthly_fee(int monthly_fee) {
        this.monthly_fee = monthly_fee;
    }

    @Override
    public String toString() {
        return "Gym{" +
                "gym_id=" + gym_id +
                ", gym_name='" + gym_name + '\'' +
                ", monthly_fee=" + monthly_fee +
                '}';
    }
}