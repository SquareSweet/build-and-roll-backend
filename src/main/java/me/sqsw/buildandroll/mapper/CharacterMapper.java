package me.sqsw.buildandroll.mapper;

import me.sqsw.buildandroll.dto.CharacterCreateRequest;
import me.sqsw.buildandroll.model.*;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class CharacterMapper {
    public CharacterSheet fromCreateToModel(
            CharacterCreateRequest createRequest,
            User user,
            Race race,
            CharacterClass characterClass,
            Set<CharacterStat> stats,
            Set<Spell> spells) {
        return new CharacterSheet(
                null,
                user,
                createRequest.getName(),
                1,
                race,
                characterClass,
                stats,
                spells,
                null
                );
    }
}
