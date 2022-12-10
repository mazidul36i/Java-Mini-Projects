package org.sb201.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int trainer_id;
    private String trainer_name;
    private int year_of_experience;
    private String email;

    @ElementCollection
    @OneToMany
    @JoinColumn(name = "trainer_id")
    private List<Gym> gyms;

    public Trainer() {
    }

    public Trainer(int trainer_id, String trainer_name, int year_of_experience, String email) {
        this.trainer_id = trainer_id;
        this.trainer_name = trainer_name;
        this.year_of_experience = year_of_experience;
        this.email = email;
    }

    public int getTrainer_id() {
        return trainer_id;
    }

    public void setTrainer_id(int trainer_id) {
        this.trainer_id = trainer_id;
    }

    public String getTrainer_name() {
        return trainer_name;
    }

    public void setTrainer_name(String trainer_name) {
        this.trainer_name = trainer_name;
    }

    public int getYear_of_experience() {
        return year_of_experience;
    }

    public void setYear_of_experience(int year_of_experience) {
        this.year_of_experience = year_of_experience;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "trainer_id=" + trainer_id +
                ", trainer_name='" + trainer_name + '\'' +
                ", year_of_experience=" + year_of_experience +
                ", email='" + email + '\'' +
                '}';
    }
}
