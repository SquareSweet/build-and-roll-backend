package me.sqsw.buildandroll.mapper;

import me.sqsw.buildandroll.dto.SpellResponse;
import me.sqsw.buildandroll.dto.SpellsForClassResponse;
import me.sqsw.buildandroll.model.Spell;
import org.springframework.stereotype.Component;

@Component
public class SpellMapper {
    public SpellResponse toDto(Spell spell) {
        return new SpellResponse(
                spell.getId(),
                spell.getName(),
                spell.getLevel(),
                spell.getSchool(),
                spell.getCharacterClass(),
                spell.getProperties());
    }

    public SpellsForClassResponse toDtoForClass(Spell spell) {
        return new SpellsForClassResponse(
                spell.getId(),
                spell.getName(),
                spell.getLevel(),
                spell.getSchool(),
                spell.getProperties());
    }
}
