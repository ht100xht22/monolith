package kth.ht100x.monolith.repository;

import kth.ht100x.monolith.model.Lesson;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LessonRepository {
    public List<Lesson> findAll() {
        List<Lesson> lessons = new ArrayList<>();
        lessons.add(new Lesson(LocalDate.of(2022,10,15), LocalTime.of(10, 0),"Individual", "Beginner", "Guitar", "N/A"));
        lessons.add(new Lesson(LocalDate.of(2022,10,16), LocalTime.of(10, 0), "Group", "Beginner", "Violin", "N/A"));
        lessons.add(new Lesson(LocalDate.of(2022,10,17), LocalTime.of(11, 0), "Ensemble", "intermediate", "Guitar", "N/A"));
        lessons.add(new Lesson(LocalDate.of(2022,10,18), LocalTime.of(12, 0), "Individual", "Beginner", "Piano", "N/A"));
        lessons.add(new Lesson(LocalDate.of(2022,10,19), LocalTime.of(13, 0), "Group", "advanced", "Flute", "N/A"));
        return lessons;
    }
}
