package kth.ht100x.monolith.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Lesson {

    private final UUID id;
    private final LocalDate from;
    private final LocalTime time;
    private final String level;
    private final String instrument;
    private final String genre;
    private final String type;

    public Lesson(LocalDate from, LocalTime time, String type, String level, String instrument, String genre) {
        this.id = UUID.randomUUID();
        this.from = from;
        this.time = time;
        this.type = type;
        this.level = level;
        this.instrument = instrument;
        this.genre = genre;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getType() {
        return type;
    }

    public String getLevel() {
        return level;
    }

    public String getInstrument() {
        return instrument;
    }

    public String getGenre() {
        return genre;
    }
}
