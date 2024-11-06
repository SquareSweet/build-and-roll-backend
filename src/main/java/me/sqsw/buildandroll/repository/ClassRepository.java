package me.sqsw.buildandroll.repository;

import me.sqsw.buildandroll.model.CharacterClass;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClassRepository extends CrudRepository<CharacterClass, Integer> {
    Optional<CharacterClass> findByName(String name);
}
