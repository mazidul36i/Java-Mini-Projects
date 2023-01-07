package org.masai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class PersonService {

    @Autowired
    @Qualifier("theMap")
    private Map<Person, Gym> theMap;

    @Autowired
    @Qualifier("personList")
    private List<Person> theList;

    @Autowired(required = false)
    Environment env;

    private String appName;

    public PersonService() {
    }

    public void printMap() {
        theMap.forEach(((person, gym) -> {
            System.out.println("================================");
            System.out.println(person);
            System.out.println(gym);
        }));
    }

    public void printList() {
        theList.sort((o1, o2) -> {
            if (o1.getAge() > o2.getAge()) return -1;
            else if (o1.getAge() < o2.getAge()) return 1;
            return 0;
        });

        theList.forEach(System.out::println);
    }

    public void printAppName() {

        if (env == null) {
            System.out.println("Failed to load properties file!");
        } else {
            appName = env.getProperty("AppName");
        }

        System.out.println(appName);
    }

}
