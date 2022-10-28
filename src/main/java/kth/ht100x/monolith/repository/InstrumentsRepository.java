package kth.ht100x.monolith.repository;

import kth.ht100x.monolith.model.Instruments;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InstrumentsRepository {

    public List<Instruments> instruments;

    public InstrumentsRepository() {
        this.instruments = new ArrayList<>();
        instruments.add(new Instruments(1, "Piano", "casio", "2022-10-14", 200, Boolean.TRUE, "N/A"));
        instruments.add(new Instruments(2, "Bass", "casio", "2022-10-13", 222, Boolean.FALSE, "N/A"));
        instruments.add(new Instruments(3, "Violin", "casio", "2022-10-16", 211, Boolean.FALSE, "N/A"));
        instruments.add(new Instruments(4, "Flute", "casio", "2022-10-17", 244, Boolean.FALSE, "N/A"));
        instruments.add(new Instruments(5, "Drums", "casio", "2022-10-18", 255, Boolean.FALSE, "N/A"));
        instruments.add(new Instruments(6, "Gitar", "casio", "2022-10-19", 266, Boolean.FALSE, "N/A"));
    }

    public List<Instruments> findAll() {
        return instruments.stream().filter(instrument -> instrument.getRentedByWho().equalsIgnoreCase("N/A")).collect(Collectors.toList());
    }


    public Instruments findOneById(int instrumentID) {
        return instruments.stream().filter(instruments -> instruments.getId() == instrumentID).findFirst().get();
    }

    public void save(Instruments instrument) {
        for (int i = 0; i < instruments.size(); i++) {
            if (instruments.get(i).getId() == (instrument.getId())) {
                instruments.add(instrument);
                instruments.remove(i);
                return;
            }
        }
    }
}
