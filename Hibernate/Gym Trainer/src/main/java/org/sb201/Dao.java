package org.sb201;

import org.sb201.bean.Gym;
import org.sb201.bean.Person;
import org.sb201.bean.Trainer;
import org.sb201.exceptions.GymException;
import org.sb201.exceptions.TrainerException;

import java.util.List;

public interface Dao {

    public void addGym(Gym gym);

    public void registerPerson(Person person, int gym_id) throws GymException;

    public void registerTrainer(Trainer trainer);

    public void assignTrainerWithGym(int trainer_id, int gym_id) throws TrainerException, GymException;

    List<Person> getAllthePersonByGymName(String gym_name) throws GymException;

}
