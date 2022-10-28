package kth.ht100x.monolith.repository;

import kth.ht100x.monolith.model.Instructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InstructorRepository {
    private final List<Instructor> instructors;

    public InstructorRepository() {
        this.instructors = new ArrayList<>();
        instructors.add(new Instructor(1, "Lay", "Bob", "lay.bob@kth.se", "6326532632"));
        instructors.add(new Instructor(2, "Bob", "Erik", "bob.erik@kth.se", "6326532632"));
        instructors.add(new Instructor(3, "Erik", "Dave", "Erik.dave@kth.se", "6326532632"));
        instructors.add(new Instructor(4, "Dave", "Rick", "dave.rick@kth.se", "6326532632"));
    }

    public List<Instructor> findAll() {
        return instructors;
    }

    public Instructor findOneById(int id) {
        return instructors.stream()
                .filter(instructor -> instructor.getId() == id)
                .findFirst()
                .get();
    }
}
