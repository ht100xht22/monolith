package kth.ht100x.monolith.service;

import kth.ht100x.monolith.model.Instructor;
import kth.ht100x.monolith.repository.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {
    private final InstructorRepository instructorRepository;

    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public List<Instructor> findAll() {
        return instructorRepository.findAll();
    }

    public Instructor findOneById(int id) {
        return instructorRepository.findOneById(id);
    }
}
