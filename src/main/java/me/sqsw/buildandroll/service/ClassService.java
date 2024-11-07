package me.sqsw.buildandroll.service;

import me.sqsw.buildandroll.dto.CharacterClassResponse;
import me.sqsw.buildandroll.model.CharacterClass;

import java.util.List;

public interface ClassService {
    List<CharacterClassResponse> getAll();
    CharacterClass getById(Integer id);
}
