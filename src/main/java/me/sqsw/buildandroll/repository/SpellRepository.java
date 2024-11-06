package me.sqsw.buildandroll.repository;

import me.sqsw.buildandroll.model.School;
import me.sqsw.buildandroll.model.Spell;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpellRepository extends CrudRepository<Spell, Integer>  {
    List<Spell> findAll();
    List<Spell> findByNameLike(String name);
    List<Spell> findBySchool(School school);
}
