package me.sqsw.buildandroll.repository;

import me.sqsw.buildandroll.model.Weapon;
import me.sqsw.buildandroll.model.WeaponType;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WeaponRepository extends CrudRepository<Weapon, Integer> {
    List<Weapon> findBy(PageRequest pageRequest);
    List<Weapon> findAllByType(WeaponType type, PageRequest pageRequest);
}
