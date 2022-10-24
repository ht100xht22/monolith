package kth.ht100x.monolith.model.form;

public class BookingUpdateForm {
    private String instructorId;

    public BookingUpdateForm(int id) {
        this.instructorId = String.valueOf(id);
    }

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }
}
