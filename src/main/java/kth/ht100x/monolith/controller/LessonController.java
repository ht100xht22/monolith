package kth.ht100x.monolith.controller;

import kth.ht100x.monolith.model.Lesson;
import kth.ht100x.monolith.service.LessonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        List<Lesson> lessons = lessonService.findAllLessons();
        model.addAttribute("lessons", lessons);
        return "pages/lessons/lessons";
    }
}
