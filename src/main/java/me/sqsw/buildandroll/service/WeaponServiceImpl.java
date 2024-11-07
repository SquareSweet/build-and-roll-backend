package me.sqsw.buildandroll.service;

import lombok.RequiredArgsConstructor;
import me.sqsw.buildandroll.dto.WeaponResponse;
import me.sqsw.buildandroll.mapper.WeaponMapper;
import me.sqsw.buildandroll.model.Weapon;
import me.sqsw.buildandroll.model.WeaponType;
import me.sqsw.buildandroll.repository.WeaponRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WeaponServiceImpl implements WeaponService {
    private final WeaponRepository repository;
    private final WeaponMapper mapper;

    @Override
    public List<WeaponResponse> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<WeaponResponse> getFiltered(String type, String name, Integer page, Integer pageSize) {
        WeaponType weaponType = type == null ? null : WeaponType.valueOf(type);
        String nameFilter = name == null ? null : "%" + name + "%";

        if (weaponType == null && nameFilter == null) {
            return repository.findBy(PageRequest.of(page,pageSize))
                    .stream().map(mapper::toDto).collect(Collectors.toList());
        } else if (weaponType == null) {
            return repository.findAllByNameLikeIgnoreCase(nameFilter, PageRequest.of(page,pageSize))
                    .stream().map(mapper::toDto).collect(Collectors.toList());
        } else if (nameFilter == null) {
            return repository.findAllByType(weaponType, PageRequest.of(page,pageSize))
                    .stream().map(mapper::toDto).collect(Collectors.toList());
        } else {
            return repository.findAllByNameLikeIgnoreCaseAndType(nameFilter, weaponType, PageRequest.of(page,pageSize))
                    .stream().map(mapper::toDto).collect(Collectors.toList());
        }
    }
}
