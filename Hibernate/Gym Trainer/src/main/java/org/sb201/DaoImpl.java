package org.sb201;

import org.sb201.bean.Gym;
import org.sb201.bean.Person;
import org.sb201.bean.Trainer;
import org.sb201.exceptions.GymException;
import org.sb201.exceptions.TrainerException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class DaoImpl implements Dao {

    static EntityManagerFactory emf;
    static EntityManager em;

    static {
        emf = Persistence.createEntityManagerFactory("gym");
        em = emf.createEntityManager();
    }

    @Override
    public void addGym(Gym gym) {
        em.getTransaction().begin();
        em.persist(gym);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void registerPerson(Person person, int gym_id) throws GymException {
        em.getTransaction().begin();
        Gym gym = em.find(Gym.class, gym_id);
        if (gym == null) {
            throw new GymException("Gym not found!");
        }

        gym.getPersons().add(person);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void registerTrainer(Trainer trainer) {
        em.getTransaction().begin();
        em.persist(trainer);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void assignTrainerWithGym(int trainer_id, int gym_id) throws TrainerException, GymException {
        Trainer trainer = em.find(Trainer.class, trainer_id);
        if (trainer == null) {
            throw new TrainerException("Trainer not found!");
        }
        Gym gym = em.find(Gym.class, gym_id);
        if (gym == null) {
            throw new GymException("Gym not found!");
        }
        gym.setTrainer_id(trainer_id);
        em.close();
    }

    @Override
    public List<Person> getAllthePersonByGymName(String gym_name) throws GymException {
        Query query = em.createQuery("SELECT g from Gym WHERE gym_name= :name");
        query.setParameter(1, gym_name);

        Gym gym = (Gym) query.getSingleResult();

        if (gym == null) {
            throw new GymException("Gym not found!");
        }

        return gym.getPersons();
    }
}
