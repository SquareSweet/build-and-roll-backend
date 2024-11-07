package me.sqsw.buildandroll.mapper;

import me.sqsw.buildandroll.dto.CharacterClassResponse;
import me.sqsw.buildandroll.model.CharacterClass;
import org.springframework.stereotype.Component;

@Component
public class CharacterClassMapper {
    public CharacterClassResponse toDto(CharacterClass characterClass) {
        return new CharacterClassResponse(characterClass.getId(), characterClass.getName());
    }
}
