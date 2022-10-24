package kth.ht100x.monolith.model;

public class Instructor extends Person {
    public Instructor(int id, String fName, String lName, String email, String phoneNumber) {
        super(id, fName, lName, email, phoneNumber);
    }

    public Instructor() {
        super();
    }
}
