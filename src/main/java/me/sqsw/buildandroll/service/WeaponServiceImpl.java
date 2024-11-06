package me.sqsw.buildandroll.service;

import lombok.RequiredArgsConstructor;
import me.sqsw.buildandroll.model.Weapon;
import me.sqsw.buildandroll.model.WeaponType;
import me.sqsw.buildandroll.repository.WeaponRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WeaponServiceImpl implements WeaponService {
    private final WeaponRepository repository;

    @Override
    public List<Weapon> getAll(Integer page, Integer pageSize) {
        return repository.findBy(PageRequest.of(page,pageSize));
    }

    @Override
    public List<Weapon> getFiltered(String type, String name, Integer page, Integer pageSize) {
        WeaponType weaponType = type == null ? null : WeaponType.valueOf(type);
        String nameFilter = name == null ? null : "%" + name + "%";

        if (weaponType == null && nameFilter == null) {
            return repository.findBy(PageRequest.of(page,pageSize));
        } else if (weaponType == null) {
            return repository.findAllByNameLikeIgnoreCase(nameFilter, PageRequest.of(page,pageSize));
        } else if (nameFilter == null) {
            return repository.findAllByType(weaponType, PageRequest.of(page,pageSize));
        } else {
            return repository.findAllByNameLikeIgnoreCaseAndType(nameFilter, weaponType, PageRequest.of(page,pageSize));
        }
    }
}
