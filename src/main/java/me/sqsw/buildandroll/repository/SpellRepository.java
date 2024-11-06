package me.sqsw.buildandroll.repository;

import me.sqsw.buildandroll.model.School;
import me.sqsw.buildandroll.model.Spell;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpellRepository extends CrudRepository<Spell, Integer>  {
    List<Spell> findAll();
    List<Spell> findByCharacterClass_Id(Integer classId, PageRequest pageRequest);
    List<Spell> findByCharacterClass_IdAndLevelLessThanEqual(Integer classId, Integer level, PageRequest pageRequest);
    List<Spell> findBySchool(School school);
}
