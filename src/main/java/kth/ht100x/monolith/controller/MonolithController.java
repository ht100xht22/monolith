package kth.ht100x.monolith.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "")
public class MonolithController {

    @GetMapping(path = "")
    public String index() {
        return "pages/index";
    }
}
