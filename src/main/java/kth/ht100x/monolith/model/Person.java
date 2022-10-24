package kth.ht100x.monolith.model;

public class Person {


    private final int id;
    private final String fName;
    private final String lName;
    private final String email;
    private final String phoneNumber;

    public Person(int id, String fName, String lName, String email, String phoneNumber) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Person() {
        this.id = 0;
        this.fName = null;
        this.lName = null;
        this.email = null;
        this.phoneNumber = null;
    }

    public int getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getName() {
        return getfName() + " " + getlName();
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
