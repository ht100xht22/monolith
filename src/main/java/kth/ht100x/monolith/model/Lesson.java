package kth.ht100x.monolith.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Lesson {

    private final LocalDate from;
    private final LocalTime to;
    private final String level;
    private final String instrument;
    private final String genre;
    private final String type;

    public Lesson(LocalDate from, LocalTime to, String type, String level, String instrument, String genre) {
        this.from = from;
        this.to = to;
        this.type = type;
        this.level = level;
        this.instrument = instrument;
        this.genre = genre;
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalTime getTo() {
        return to;
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
