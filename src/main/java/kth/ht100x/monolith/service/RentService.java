package kth.ht100x.monolith.service;

import kth.ht100x.monolith.model.Instruments;
import kth.ht100x.monolith.model.Person;
import kth.ht100x.monolith.model.Rent;
import kth.ht100x.monolith.repository.RentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentService {

    private final RentRepository repository;
    private final ProfileService profileService;

    private final InstrumentServices instrumentServices;


    public RentService(RentRepository repository, InstrumentServices instrumentServices, ProfileService profileService) {
        this.repository = repository;
        this.profileService = profileService;
        this.instrumentServices = instrumentServices;
    }

    public List<Rent> findAllRents() {

        return repository.findAll();
    }

    public Instruments findInstrumentById(int instrumentId) {
        return instrumentServices.findOneById(instrumentId);
    }

    public Person findStudentById(Long personId) {
        return profileService.findOneById(personId);
    }

    public void save(int instrumentId, Long personId) {
        Instruments instruments = findInstrumentById(instrumentId);
        Person person = findStudentById(personId);
        repository.add(instruments, person);
        instrumentServices.update(instrumentId, personId);


    }


}
