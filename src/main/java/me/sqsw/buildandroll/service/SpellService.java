package me.sqsw.buildandroll.service;

import me.sqsw.buildandroll.model.Spell;

import java.util.List;

public interface SpellService {
    List<Spell> getAll();
    List<Spell> getFiltered(Integer classId, Integer level, String school, String name, Integer page, Integer perPage);
}
