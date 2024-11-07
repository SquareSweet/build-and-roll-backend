package me.sqsw.buildandroll.service;

import me.sqsw.buildandroll.dto.CharacterClassResponse;

import java.util.List;

public interface ClassService {
    List<CharacterClassResponse> getAll();
}
