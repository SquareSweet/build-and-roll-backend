package me.sqsw.buildandroll.controller;

import lombok.RequiredArgsConstructor;
import me.sqsw.buildandroll.model.CharacterClass;
import me.sqsw.buildandroll.service.ClassService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lib/class")
@RequiredArgsConstructor
public class ClassesController {
    private final ClassService classService;

    @GetMapping("/all")
    public List<CharacterClass> getAll() {
        return classService.getAll();
    }
}