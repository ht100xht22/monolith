package kth.ht100x.monolith.model;

public class Rent {

    private final Instruments instruments;
    private final Person person;

    public Rent(Instruments instruments, Person person) {
        this.instruments = instruments;
        this.person = person;
    }

    public Instruments getInstruments() {
        return instruments;
    }

    public Person getPerson() {
        return person;
    }


}
