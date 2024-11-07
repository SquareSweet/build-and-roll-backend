package me.sqsw.buildandroll.service;

import me.sqsw.buildandroll.dto.CharacterCreateRequest;
import me.sqsw.buildandroll.dto.CharacterFullResponse;
import me.sqsw.buildandroll.dto.CharacterShortResponse;
import me.sqsw.buildandroll.model.CharacterSheet;

import java.util.List;
import java.util.Optional;

public interface CharacterService {
    List<CharacterShortResponse> getAll();
    List<CharacterShortResponse> getOwn();
    List<CharacterShortResponse> getByUser(Long userId);
    CharacterFullResponse getCharacter(Long characterId);
    CharacterFullResponse createCharacter(CharacterCreateRequest character);
    CharacterFullResponse addWeapon(Long characterId, Integer weaponId);
    CharacterFullResponse addSpell(Long characterId, Integer spellId);
    void deleteCharacter(Long characterId);
}
