package kth.ht100x.monolith.controller;


import kth.ht100x.monolith.model.Instruments;
import kth.ht100x.monolith.model.Person;
import kth.ht100x.monolith.model.Rent;
import kth.ht100x.monolith.service.RentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(path = "/rents")
public class RentController {

    private final RentService rentService;

    public RentController(RentService rentService) {
        this.rentService = rentService;
    }
    
    @GetMapping("")
    public String rents(Model model) {
        List<Rent> rents = rentService.findAllRents();
        model.addAttribute("rents", rents);

        return "pages/rents/rents";
    }

    @GetMapping("/new")
    public String formRent(Model model, @RequestParam(name = "instruments") String instruments, @RequestParam(name = "student") Long studentId) {
        Person person = rentService.findStudentById(studentId);
        Instruments instruments1 = rentService.findInstrumentById(Integer.parseInt(instruments));
        model.addAttribute("instrumens", instruments1);
        model.addAttribute("person", person);
        return "pages/rents/rentFrom";
    }

    @PostMapping("/new")
    public String submit(@RequestParam(name = "instruments") int instrumentId, @RequestParam(name = "student") Long studentId) {
        rentService.save(instrumentId, studentId);
        return "redirect:";
    }

}
