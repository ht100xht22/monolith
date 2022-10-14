package kth.ht100x.monolith.service;

import kth.ht100x.monolith.model.Instruments;
import kth.ht100x.monolith.model.from.InstrumentFilterFrom;
import kth.ht100x.monolith.repository.InstrumentsRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstrumentServices {

    private final InstrumentsRepository instrumentsRepository;

    public InstrumentServices(InstrumentsRepository instrumentsRepository) {
        this.instrumentsRepository = instrumentsRepository;
    }

    public List<Instruments> findAllInstruments() {
        List<Instruments> instruments = instrumentsRepository.findAll();
        return instruments.stream()
                .sorted(Comparator.comparing(Instruments::getBrand))
                .collect(Collectors.toList());
    }

    public List<Instruments> findInstrumentsByType(InstrumentFilterFrom form) {
        List<Instruments> instruments = instrumentsRepository.findAll();
        instruments = instruments.stream().filter(instruments1 -> form.getType().equalsIgnoreCase("") || instruments1.getType().equalsIgnoreCase(form.getType())).collect(Collectors.toList());
        return instruments;
    }

}
