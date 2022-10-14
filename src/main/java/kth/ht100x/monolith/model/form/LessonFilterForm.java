package kth.ht100x.monolith.model.form;

import java.time.LocalDate;

public class LessonFilterForm {
    private LocalDate from;
    private LocalDate to;
    private String type;
    private String level;
    private String genre;

    public LessonFilterForm() {
        this.from = LocalDate.now();
        this.to = LocalDate.now().plusDays(30);
        this.type = "All";
        this.level = "All";
        this.genre = "N/A";


    }

    public LessonFilterForm(String from, String to, String type, String level, String genre) {
        this.from = LocalDate.parse(from);
        this.to = LocalDate.parse(to);
        this.type = type;
        this.level = level;
        this.genre = genre;
    }

    public String getFrom() {
        return from.toString();
    }

    public LocalDate getLocalDateFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from.isEmpty() ? LocalDate.now() : LocalDate.parse(from);
    }

    public String getTo() {
        return to.toString();
    }

    public LocalDate getLocalDateTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to.isEmpty()? from.plusDays(30) : LocalDate.parse(to);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
