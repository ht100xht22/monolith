package kth.ht100x.monolith.repository;

import kth.ht100x.monolith.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProfileRepository {
    public List<Person> findAll() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Bob", 30, "Bygga"));
        people.add(new Person("John", 25, "Spela"));
        people.add(new Person("John", 22, "sdf"));
        people.add(new Person("John", 26, "21po"));
        people.add(new Person("John", 20, "lak"));
        people.add(new Person("John", 29, "dfdf"));
        people.add(new Person("John", 22, "asdf"));
        return people;
    }
}
