package kth.ht100x.monolith.repository;

import kth.ht100x.monolith.model.Booking;
import kth.ht100x.monolith.model.Lesson;
import kth.ht100x.monolith.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookingRepository {
    private final List<Booking> bookings;

    public BookingRepository() {
        bookings = new ArrayList<>();
    }

    public List<Booking> findAll() {
        return bookings;
    }

    public void save(Lesson lesson, Person person) {
        bookings.add(new Booking(lesson, person));
    }
}
