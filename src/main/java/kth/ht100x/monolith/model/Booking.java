package kth.ht100x.monolith.model;

public class Booking {
    private final Long id;
    private final Lesson lesson;
    private final Person person;
    private final Instructor instructor;

    public Booking(Long id, Lesson lesson, Person person) {
        this.id = id;
        this.lesson = lesson;
        this.person = person;
        this.instructor = new Instructor();
    }

    public Booking(Long id, Lesson lesson, Person person, Instructor instructor) {
        this.id = id;
        this.lesson = lesson;
        this.person = person;
        this.instructor = instructor;
    }

    public Booking() {
        this.id = null;
        this.lesson = null;
        this.person = null;
        this.instructor = null;

    }

    public Booking(Booking booking, Instructor instructor) {
        this.id = booking.getId();
        this.lesson = booking.getLesson();
        this.person = booking.getPerson();
        this.instructor = instructor;
    }

    public Long getId() {
        return id;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public Person getPerson() {
        return person;
    }

    public Instructor getInstructor() {
        return instructor;
    }
}
