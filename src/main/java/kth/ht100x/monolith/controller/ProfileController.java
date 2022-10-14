package kth.ht100x.monolith.controller;

import kth.ht100x.monolith.model.Person;
import kth.ht100x.monolith.service.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/profiles")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping(path = "")
    public String findAllProfiles(Model model) {
        List<Person> persons = profileService.findAll();
        model.addAttribute("persons", persons);
        return "/pages/profile/profiles";
    }
}
