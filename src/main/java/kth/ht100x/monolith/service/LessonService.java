package kth.ht100x.monolith.service;

import kth.ht100x.monolith.model.Lesson;
import kth.ht100x.monolith.model.Person;
import kth.ht100x.monolith.model.form.LessonFilterForm;
import kth.ht100x.monolith.repository.LessonRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<Lesson> findAllLessonsByFilter(LessonFilterForm form) {
        return lessonRepository.findAll()
                .stream()
                .filter(lesson -> lesson.getFrom().isAfter(form.getLocalDateFrom()))
                .filter(lesson -> lesson.getFrom().isBefore(form.getLocalDateTo()))
                .filter(lesson -> form.getType().equalsIgnoreCase("All") || lesson.getType().equalsIgnoreCase(form.getType()))
                .filter(lesson -> form.getLevel().equalsIgnoreCase("All") || lesson.getLevel().equalsIgnoreCase(form.getLevel()))
                .filter(lesson -> form.getGenre().equalsIgnoreCase("N/A") || lesson.getGenre().equalsIgnoreCase(form.getGenre()))
                .collect(Collectors.toList());
    }

    public Lesson findOneById(String lessonId) {
        return lessonRepository.findOneById(lessonId);
    }

    public void update(String lessonId, Person person) {
        Lesson lesson = findOneById(lessonId);
        lesson.addStudent(person);
        lessonRepository.save(lesson);
    }
}
