package kth.ht100x.monolith.repository;

import kth.ht100x.monolith.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProfileRepository {
    public List<Person> people;

    public ProfileRepository() {
        this.people = new ArrayList<>();
        people.add(new Person(1, "Bob", "Bobboy", "Bob@gmail.com", "6326532632"));
        people.add(new Person(2, "Erik", "Eriksson", "Erik@gmail.com", "326532632"));
        people.add(new Person(3, "Luke", "Lukesson", "Luke@gmail.com", "26532632"));
        people.add(new Person(4, "Dave", "Davesson", "Dave@gmail.com", "6532632"));
        people.add(new Person(5, "John", "Johnsson", "John@gmail.com", "532632"));
        people.add(new Person(6, "Rick", "Ricksson", "Rick@gmail.com", "32632"));
    }

    public List<Person> findAll() {

        return people;
    }

    public Person findOneById(Long id) {

        return people.stream().filter(person -> person.getId() == id).findFirst().get();
    }
}
