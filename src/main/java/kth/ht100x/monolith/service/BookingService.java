package kth.ht100x.monolith.service;

import kth.ht100x.monolith.model.Booking;
import kth.ht100x.monolith.model.Lesson;
import kth.ht100x.monolith.model.Person;
import kth.ht100x.monolith.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private final ProfileService personService;
    private final LessonService lessonService;
    private final BookingRepository bookingRepository;

    public BookingService(ProfileService personService, LessonService lessonService, BookingRepository bookingRepository) {
        this.personService = personService;
        this.lessonService = lessonService;
        this.bookingRepository = bookingRepository;
    }

    public Person findStudentById(Long personId) {
        return personService.findOneById(personId);
    }

    public Lesson findLessonById(String lessonId) {
        return lessonService.findOneById(lessonId);
    }

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public void save(String lessonId, Long studentId) {
        Lesson lesson = findLessonById(lessonId);
        Person person = findStudentById(studentId);
        bookingRepository.save(lesson, person);
        lessonService.update(lessonId, person);
    }
}
