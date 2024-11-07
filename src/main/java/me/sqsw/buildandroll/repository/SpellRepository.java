package me.sqsw.buildandroll.repository;

import me.sqsw.buildandroll.model.School;
import me.sqsw.buildandroll.model.Spell;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpellRepository extends CrudRepository<Spell, Integer>  {
    List<Spell> findAll();
    List<Spell> findByCharacterClass_Id(Integer classId);
    @Query("select s from Spell s " +
            "join s.characterClass c where " +
            "(:classId is null or c.id = :classId) " +
            "and (:level is null or s.level = :level) " +
            "and (:school is null or s.school = :school) " +
            "and (:name is null or lower(s.name) like :name)")
    List<Spell> findFiltered(Integer classId, Integer level, School school, String name, PageRequest pageRequest);
}
