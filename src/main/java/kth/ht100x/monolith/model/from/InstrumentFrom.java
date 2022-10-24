package kth.ht100x.monolith.model.from;

import kth.ht100x.monolith.model.Instruments;

public class InstrumentFrom {

    private Instruments instruments;

    public InstrumentFrom(Instruments instruments) {
        this.instruments = instruments;
    }

    public Instruments getInstruments() {
        return instruments;
    }

    public void setInstruments(Instruments instruments) {
        this.instruments = instruments;
    }
}
