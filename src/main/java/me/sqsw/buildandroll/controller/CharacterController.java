package me.sqsw.buildandroll.controller;

import lombok.RequiredArgsConstructor;
import me.sqsw.buildandroll.dto.CharacterCreateRequest;
import me.sqsw.buildandroll.model.CharacterSheet;
import me.sqsw.buildandroll.service.CharacterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/character")
@RequiredArgsConstructor
public class CharacterController {
    private final CharacterService characterService;

    @GetMapping("/all")
    public List<CharacterSheet> getAll() {
        return characterService.getAll();
    }

    @PostMapping("/create")
    public CharacterSheet create(@RequestBody CharacterCreateRequest request) {
        return characterService.createCharacter(request);
    }
}
