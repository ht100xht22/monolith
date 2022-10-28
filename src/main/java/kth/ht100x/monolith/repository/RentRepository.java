package kth.ht100x.monolith.repository;

import kth.ht100x.monolith.model.Instruments;
import kth.ht100x.monolith.model.Person;
import kth.ht100x.monolith.model.Rent;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RentRepository {

    public List<Rent> rent;

    public RentRepository() {
        rent = new ArrayList<>();
    }

    public List<Rent> findAll() {
        return rent;
    }

    public void add(Instruments instruments, Person person) {
        rent.add(new Rent(instruments, person));
    }
}
