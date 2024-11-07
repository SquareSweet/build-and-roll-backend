package me.sqsw.buildandroll.service;

import me.sqsw.buildandroll.dto.SpellResponse;
import me.sqsw.buildandroll.dto.SpellsForClassResponse;

import java.util.List;

public interface SpellService {
    List<SpellResponse> getAll();
    List<SpellsForClassResponse> getAllForClass(Integer classId);
    List<SpellResponse> getFiltered(Integer classId, Integer level, String school, String name, Integer page, Integer perPage);
}
