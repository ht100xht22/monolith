package kth.ht100x.monolith.controller;

import kth.ht100x.monolith.model.Instruments;
import kth.ht100x.monolith.service.InstrumentServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping(path = "/instruments")
public class InstrumentController {
    private final InstrumentServices instrumentServices;

    public InstrumentController(InstrumentServices instrumentServices) {
        this.instrumentServices = instrumentServices;
    }


    @GetMapping(path = "")
    public String findAllInsturments(Model model) {
        List<Instruments> instruments = instrumentServices.findAllInstruments();
        model.addAttribute("instruments", instruments);
        return "pages/instrument/instruments";
    }
    
}
