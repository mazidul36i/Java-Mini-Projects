package org.sb201.config;

import org.sb201.Gym;
import org.sb201.Person;
import org.springframework.context.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = {"org.sb201"})
@PropertySource(value = "info.properties")
public class AppConfig {

    @Bean("theMap")
    public Map<Person, Gym> getTheMap() {
        Map<Person, Gym> map = new HashMap<>();
        map.put(new Person(1, "Amit", "amit@email.com", 19, "8493284325"), new Gym(1, "Masai fitness", 3000));
        map.put(new Person(2, "Ankush", "ankush@email.com", 33, "74893285454"), new Gym(1, "Masai fitness", 3000));
        map.put(new Person(3, "Shubhendu", "shubhendu@email.com", 43, "7489235495"), new Gym(1, "Masai fitness", 3000));
        return map;
    }

    @Bean("personList")
    public List<Person> getPersonList() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Amit", "amit@email.com", 19, "8493284325"));
        persons.add(new Person(2, "Ankush", "ankush@email.com", 33, "74893285454"));
        persons.add(new Person(3, "Shubhendu", "shubhendu@email.com", 43, "7489235495"));
        persons.add(new Person(4, "Mazidul Islam", "mazidul@email.com", 19, "857389457"));
        persons.add(new Person(5, "Shubham", "sbubham@email.com", 21, "748935354345"));
        return persons;
    }

}
