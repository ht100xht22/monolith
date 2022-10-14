package kth.ht100x.monolith.controller;

import kth.ht100x.monolith.model.Booking;
import kth.ht100x.monolith.model.Lesson;
import kth.ht100x.monolith.model.Person;
import kth.ht100x.monolith.service.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ControllerAdvice
@RequestMapping(path = "/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping(path = "")
    public String bookings(Model model) {
        List<Booking> bookings =  bookingService.findAll();
        model.addAttribute("bookings", bookings);
        return "pages/bookings/bookings";
    }

    @GetMapping("/new")
    public String form(Model model, @RequestParam(name = "lesson") String lessonId, @RequestParam(name = "student") Long studentId) {
        Person person = bookingService.findStudentById(studentId);
        Lesson lesson = bookingService.findLessonById(lessonId);
        model.addAttribute("lesson", lesson);
        model.addAttribute("person", person);
        return "pages/bookings/form";
    }

    @PostMapping("/new")
    public String submit(@RequestParam(name = "lesson") String lessonId, @RequestParam(name = "student") Long studentId) {
        bookingService.save(lessonId, studentId);
        return "redirect:";
    }
}