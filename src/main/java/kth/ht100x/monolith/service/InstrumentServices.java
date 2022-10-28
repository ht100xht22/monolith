package kth.ht100x.monolith.service;

import kth.ht100x.monolith.model.Instruments;
import kth.ht100x.monolith.model.Person;
import kth.ht100x.monolith.model.form.InstrumentFilterFrom;
import kth.ht100x.monolith.repository.InstrumentsRepository;
import kth.ht100x.monolith.repository.RentRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstrumentServices {

    private final InstrumentsRepository instrumentsRepository;
    private final RentRepository repository;

    private final ProfileService profileService;

    public InstrumentServices(InstrumentsRepository instrumentsRepository, RentRepository repository, ProfileService profileService) {
        this.instrumentsRepository = instrumentsRepository;
        this.repository = repository;
        this.profileService = profileService;
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

    public Instruments findOneById(int instrumentId) {
        return instrumentsRepository.findOneById(instrumentId);


    }

    public void update(int instrumentId, Long studentId) {
        Instruments instruments = findOneById(instrumentId);
        Person person = findStudentById(studentId);
        Instruments entry = new Instruments(instruments, person.getName());
        instrumentsRepository.save(entry);

    }

    private Person findStudentById(Long studentId) {
        return profileService.findOneById(studentId);
    }
}
