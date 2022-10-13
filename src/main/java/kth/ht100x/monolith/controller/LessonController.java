package kth.ht100x.monolith.controller;

import kth.ht100x.monolith.model.Lesson;
import kth.ht100x.monolith.service.LessonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ControllerAdvice
@RequestMapping(path = "/lessons")
public class LessonController {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping(path = "")
    public String lessons(Model model,
                          @RequestParam(value = "from", required = false) String from,
                          @RequestParam(value = "to", required = false) String to,
                          @RequestParam(value = "type", required = false, defaultValue = "All") String type,
                          @RequestParam(value = "level", required = false, defaultValue = "All") String level,
                          @RequestParam(value = "genre", required = false, defaultValue = "N/A") String genre) {
        List<Lesson> lessons = lessonService.findAllLessonsByFilter(from, to, type, level, genre);
        model.addAttribute("lessons", lessons);
        return "pages/lessons/lessons";
    }
    @PostMapping(path = "")
    public String filter(Model model,
                          @RequestParam(value = "from", required = false) String from,
                          @RequestParam(value = "to", required = false) String to,
                          @RequestParam(value = "type", required = false, defaultValue = "All") String type,
                          @RequestParam(value = "level", required = false, defaultValue = "All") String level,
                          @RequestParam(value = "genre", required = false, defaultValue = "N/A") String genre) {
        List<Lesson> lessons = lessonService.findAllLessonsByFilter(from, to, type, level, genre);
        model.addAttribute("lessons", lessons);
        return "pages/lessons/lessons";
    }

}
