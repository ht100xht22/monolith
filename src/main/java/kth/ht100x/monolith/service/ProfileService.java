package kth.ht100x.monolith.service;

import kth.ht100x.monolith.model.Person;
import kth.ht100x.monolith.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public List<Person> findAll() {
        List<Person> people = profileRepository.findAll();
        return people.stream()
                .sorted(Comparator.comparing(Person::getlName))
                .collect(Collectors.toList());
    }

    public Person findOneById(Long id) {
        return profileRepository.findOneById(id);

    }
}
