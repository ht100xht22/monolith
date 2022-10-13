package kth.ht100x.monolith.service;

import kth.ht100x.monolith.model.Lesson;
import kth.ht100x.monolith.repository.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<Lesson> findAllLessons() {
        return lessonRepository.findAll();
    }
}
