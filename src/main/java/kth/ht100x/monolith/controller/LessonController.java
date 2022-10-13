package kth.ht100x.monolith.controller;

import kth.ht100x.monolith.model.Lesson;
import kth.ht100x.monolith.model.form.LessonFilterForm;
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
    public String lessons(Model model) {
        List<Lesson> lessons = lessonService.findAllLessonsByFilter(new LessonFilterForm());
        model.addAttribute("lessons", lessons);
        model.addAttribute("form", new LessonFilterForm());
        return "pages/lessons/lessons";
    }
    @PostMapping(path = "")
    public String filter(Model model, @ModelAttribute(value = "form") LessonFilterForm form) {
        List<Lesson> lessons = lessonService.findAllLessonsByFilter(form);
        model.addAttribute("lessons", lessons);
        model.addAttribute("form", form);
        return "pages/lessons/lessons";
    }

}
