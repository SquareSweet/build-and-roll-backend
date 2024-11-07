package me.sqsw.buildandroll.repository;

import me.sqsw.buildandroll.model.CharacterStat;
import org.springframework.data.repository.CrudRepository;

public interface StatRepository extends CrudRepository<CharacterStat, Integer> {
}
