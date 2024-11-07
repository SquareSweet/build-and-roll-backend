package me.sqsw.buildandroll.mapper;

import lombok.RequiredArgsConstructor;
import me.sqsw.buildandroll.dto.*;
import me.sqsw.buildandroll.model.*;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CharacterMapper {
    private final RaceMapper raceMapper;
    private final CharacterClassMapper classMapper;
    private final SpellMapper spellMapper;
    private final WeaponMapper weaponMapper;

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

    public CharacterShortResponse toShortResponse(CharacterSheet characterSheet) {
        return new CharacterShortResponse(
                characterSheet.getId(),
                characterSheet.getName(),
                characterSheet.getRace().getName(),
                characterSheet.getCharacterClass().getName(),
                characterSheet.getLevel()
        );
    }

    public CharacterFullResponse toFullResponse(CharacterSheet characterSheet) {
        return new CharacterFullResponse(
                characterSheet.getId(),
                characterSheet.getName(),
                characterSheet.getLevel(),
                raceMapper.toDto(characterSheet.getRace()),
                classMapper.toDto(characterSheet.getCharacterClass()),
                characterSheet.getCharacterStats() == null ? null : characterSheet.getCharacterStats().stream().map(this::statToDto).collect(Collectors.toSet()),
                characterSheet.getSpells() == null ? null : characterSheet.getSpells().stream().map(spellMapper::toDto).collect(Collectors.toSet()),
                characterSheet.getWeapons() == null ? null : characterSheet.getWeapons().stream().map(weaponMapper::toDto).collect(Collectors.toList())
        );
    }

    public StatResponse statToDto(CharacterStat stat) {
        return new StatResponse(stat.getStatId(), stat.getLevel());
    }

    public CharacterStat statFromDto(StatRequest statRequest, Long characterId) {
        return new CharacterStat(null, characterId, statRequest.getId(), statRequest.getLevel());
    }
}
