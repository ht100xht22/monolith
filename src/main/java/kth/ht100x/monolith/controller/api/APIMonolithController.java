package kth.ht100x.monolith.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class APIMonolithController {

    @GetMapping(path = "/hello")
    public String hello(@RequestParam(name = "name", defaultValue = "World") String name) {
        return "Hello " + name;
    }
}
