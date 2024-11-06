package me.sqsw.buildandroll.repository;

import me.sqsw.buildandroll.model.CharacterClass;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClassRepository extends CrudRepository<CharacterClass, Integer> {
    List<CharacterClass> findAll();
}
