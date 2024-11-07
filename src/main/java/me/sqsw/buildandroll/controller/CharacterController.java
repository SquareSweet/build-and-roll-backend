package me.sqsw.buildandroll.controller;

import lombok.RequiredArgsConstructor;
import me.sqsw.buildandroll.dto.*;
import me.sqsw.buildandroll.service.CharacterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/character")
@RequiredArgsConstructor
public class CharacterController {
    private final CharacterService characterService;

    @GetMapping("/all")
    public List<CharacterShortResponse> getAll() {
        return characterService.getAll();
    }

    @PostMapping("/create")
    public CharacterFullResponse create(@RequestBody CharacterCreateRequest request) {
        return characterService.createCharacter(request);
    }

    @GetMapping()
    public List<CharacterShortResponse> getOwn() {
        return characterService.getOwn();
    }

    @PostMapping("/addweapon")
    public CharacterFullResponse addWeapon(@RequestBody WeaponAddRequest request) {
        return characterService.addWeapon(request.getCharacterListId(), request.getWeaponId());
    }

    @PostMapping("/addspell")
    public CharacterFullResponse addSpell(@RequestBody SpellAddRequest request) {
        return characterService.addWeapon(request.getCharacterListId(), request.getSpellId());
    }
}
