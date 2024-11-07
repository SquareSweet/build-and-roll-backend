package me.sqsw.buildandroll.service;

import lombok.RequiredArgsConstructor;
import me.sqsw.buildandroll.dto.CharacterCreateRequest;
import me.sqsw.buildandroll.dto.CharacterFullResponse;
import me.sqsw.buildandroll.dto.CharacterShortResponse;
import me.sqsw.buildandroll.exception.UserNotFoundException;
import me.sqsw.buildandroll.mapper.CharacterMapper;
import me.sqsw.buildandroll.model.*;
import me.sqsw.buildandroll.repository.CharacterRepository;
import me.sqsw.buildandroll.repository.StatRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    public List<CharacterShortResponse> getAll() {
        return repository.findAll().stream().map(mapper::toShortResponse).collect(Collectors.toList());
    }

    @Override
    public List<CharacterShortResponse> getOwn() {
        User user = getUserFromContext();
        return repository.findByUser_Id(user.getId()).stream().map(mapper::toShortResponse).collect(Collectors.toList());
    }

    @Override
    public List<CharacterShortResponse> getByUser(Long userId) {
        return repository.findByUser_Id(userId).stream().map(mapper::toShortResponse).collect(Collectors.toList());
    }


    @Override
    public CharacterFullResponse getCharacter(Long characterId) {
        return mapper.toFullResponse(repository.findById(characterId).get());
    }

    @Override
    public CharacterFullResponse createCharacter(CharacterCreateRequest character) {
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
        CharacterSheet finalCharacterSheet = characterSheet;
        characterSheet.setCharacterStats(character.getStats().stream()
                .map(s -> mapper.statFromDto(s, finalCharacterSheet.getId())).collect(Collectors.toSet()));
        //statRepository.saveAll(character.getStats());
        characterSheet = repository.save(characterSheet);
        //characterSheet = repository.findById(characterSheet.getId()).get();
        return mapper.toFullResponse(characterSheet);
    }

    @Override
    public CharacterFullResponse addWeapon(Long characterId, Integer weaponId) {
        return null;
    }

    @Override
    public CharacterFullResponse addSpell(Long characterId, Integer spellId) {
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