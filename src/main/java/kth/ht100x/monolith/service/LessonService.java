package kth.ht100x.monolith.service;

import kth.ht100x.monolith.model.Lesson;
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

    public List<Lesson> findAllLessons() {
        return lessonRepository.findAll();
    }

    public List<Lesson> findAllLessonsByFilter(String localDateFrom, String localDateTo, String type, String level, String genre) {
        LocalDate from = localDateFrom.isEmpty() ? LocalDate.now() : LocalDate.parse(localDateFrom);
        LocalDate to = localDateTo.isEmpty()? LocalDate.now().plusDays(30) : LocalDate.parse(localDateTo);
        List<Lesson> lessons = lessonRepository.findAll();
        lessons = lessons.stream()
                .filter(lesson -> lesson.getFrom().isAfter(from))
                .filter(lesson -> lesson.getFrom().isBefore(to))
                .filter(lesson -> type.equalsIgnoreCase("All") || lesson.getType().equalsIgnoreCase(type))
                .filter(lesson -> level.equalsIgnoreCase("All") || lesson.getLevel().equalsIgnoreCase(level))
                .filter(lesson -> genre.equalsIgnoreCase("N/A") || lesson.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
        return lessons;
    }
}
