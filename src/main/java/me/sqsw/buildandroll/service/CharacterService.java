package me.sqsw.buildandroll.service;

import me.sqsw.buildandroll.dto.CharacterCreateRequest;
import me.sqsw.buildandroll.model.CharacterSheet;

import java.util.List;
import java.util.Optional;

public interface CharacterService {
    List<CharacterSheet> getAll();
    List<CharacterSheet> getOwn();
    List<CharacterSheet> getByUser(Long userId);
    CharacterSheet getCharacter(Long characterId);
    CharacterSheet createCharacter(CharacterCreateRequest character);
    CharacterSheet addWeapon(Long characterId, Integer weaponId);
    CharacterSheet addSpell(Long characterId, Integer spellId);
    void deleteCharacter(Long characterId);
}
