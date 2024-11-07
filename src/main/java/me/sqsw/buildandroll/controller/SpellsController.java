package me.sqsw.buildandroll.controller;

import lombok.RequiredArgsConstructor;
import me.sqsw.buildandroll.model.Spell;
import me.sqsw.buildandroll.service.SpellService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lib/spell")
@RequiredArgsConstructor
public class SpellsController {
    private final SpellService spellService;

    @GetMapping("/all")
    public List<Spell> getAll() {
        return spellService.getAll();
    }

    @GetMapping()
    public List<Spell> getFiltered(@RequestParam(required = false) Integer classId,
                                   @RequestParam(required = false) Integer level,
                                   @RequestParam(required = false) String school,
                                   @RequestParam(required = false) String search,
                                   @RequestParam(defaultValue = "1") Integer page,
                                   @RequestParam(defaultValue = "10") Integer perPage) {
        return spellService.getFiltered(classId, level, school, search, page - 1, perPage);
    }
}
