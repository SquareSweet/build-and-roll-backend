package me.sqsw.buildandroll.repository;

import me.sqsw.buildandroll.model.CharacterSheet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CharacterRepository extends CrudRepository<CharacterSheet, Long> {
    List<CharacterSheet> findAll();
    List<CharacterSheet> findByUser_Id(Long userId);
}
