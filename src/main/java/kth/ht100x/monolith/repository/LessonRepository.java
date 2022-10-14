package kth.ht100x.monolith.repository;

import kth.ht100x.monolith.model.Lesson;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class LessonRepository {
    private final List<Lesson> lessons;

    public LessonRepository() {
        this.lessons = new ArrayList<>();
        lessons.add(new Lesson(LocalDate.of(2022, 10, 15), LocalTime.of(10, 0), "Individual", "Beginner", "Guitar", "N/A", 1, 1));
        lessons.add(new Lesson(LocalDate.of(2022, 10, 16), LocalTime.of(10, 0), "Group", "Beginner", "Violin", "N/A", 4, 2));
        lessons.add(new Lesson(LocalDate.of(2022, 10, 17), LocalTime.of(11, 0), "Ensemble", "intermediate", "Guitar", "N/A", 5, 3));
        lessons.add(new Lesson(LocalDate.of(2022, 10, 18), LocalTime.of(12, 0), "Individual", "Beginner", "Piano", "N/A", 1, 1));
        lessons.add(new Lesson(LocalDate.of(2022, 10, 19), LocalTime.of(13, 0), "Group", "advanced", "Flute", "N/A", 3, 3));
    }

    public List<Lesson> findAll() {
        return lessons.stream()
                .filter(Lesson::isBookable)
                .collect(Collectors.toList());
    }

    public Lesson findOneById(String lessonId) {
        return lessons.stream()
                .filter(lesson -> lesson.getId().toString().equals(lessonId))
                .findFirst()
                .get();
    }

    public void save(Lesson lesson) {
        for (int i = 0; i < lessons.size(); i++) {
            if (lessons.get(i).getId().equals(lesson.getId())) {
                lessons.add(lesson);
                lessons.remove(i);
                return;
            }
        }
    }
}
