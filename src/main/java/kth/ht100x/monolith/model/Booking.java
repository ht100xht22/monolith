package kth.ht100x.monolith.model;

public class Booking {
    private final Lesson lesson;
    private final Person person;

    public Booking(Lesson lesson, Person person) {
        this.lesson = lesson;
        this.person = person;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public Person getPerson() {
        return person;
    }
}
