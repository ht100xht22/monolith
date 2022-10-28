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
        Long id = (long) bookings.size();
        bookings.add(new Booking(id, lesson, person));
    }

    public Booking findOneById(Long bookingId) {
        return bookings.stream()
                .filter(booking -> booking.getId().equals(bookingId))
                .findFirst()
                .get();
    }

    public void update(Booking entry) {
        bookings.removeIf(booking -> booking.getId().equals(entry.getId()));
        bookings.add(entry);
    }
}
