package me.sqsw.buildandroll.service;

import lombok.RequiredArgsConstructor;
import me.sqsw.buildandroll.dto.CharacterCreateRequest;
import me.sqsw.buildandroll.exception.UserNotFoundException;
import me.sqsw.buildandroll.mapper.CharacterMapper;
import me.sqsw.buildandroll.model.*;
import me.sqsw.buildandroll.repository.CharacterRepository;
import me.sqsw.buildandroll.repository.StatRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {
    private final UserService userService;
    private final RaceService raceService;
    private final ClassService classService;
    private final CharacterRepository repository;
    private final StatRepository statRepository;
    private final CharacterMapper mapper;

    @Override
    public List<CharacterSheet> getAll() {
        return repository.findAll();
    }

    @Override
    public List<CharacterSheet> getOwn() {
        User user = getUserFromContext();
        return repository.findByUser_Id(user.getId());
    }

    @Override
    public List<CharacterSheet> getByUser(Long userId) {
        return repository.findByUser_Id(userId);
    }


    @Override
    public CharacterSheet getCharacter(Long characterId) {
        return repository.findById(characterId).get();
    }

    @Override
    public CharacterSheet createCharacter(CharacterCreateRequest character) {
        User user = getUserFromContext();
        Race race = raceService.getById(character.getRaceId());
        CharacterClass characterClass = classService.getById(character.getClassId());

        CharacterSheet characterSheet = mapper.fromCreateToModel(
                character,
                user,
                race,
                characterClass,
                null,
                null);
        characterSheet = repository.save(characterSheet);
        characterSheet.setCharacterStats(character.getStats());
        for (CharacterStat stat : character.getStats()) {
            stat.setCharacterId(characterSheet.getId());
        }
        statRepository.saveAll(character.getStats());
        characterSheet = repository.findById(characterSheet.getId()).get();
        return characterSheet;
    }

    @Override
    public CharacterSheet addWeapon(Long characterId, Integer weaponId) {

        return null;
    }

    @Override
    public CharacterSheet addSpell(Long characterId, Integer spellId) {
        return null;
    }

    @Override
    public void deleteCharacter(Long characterId) {

    }

    private User getUserFromContext() {
        String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        return userService.getByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User " + username + " not found"));
    }
}
