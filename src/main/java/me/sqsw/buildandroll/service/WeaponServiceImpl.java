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
    public List<Weapon> getByType(String type, Integer page, Integer pageSize) {
        return repository.findAllByType(WeaponType.valueOf(type), PageRequest.of(page,pageSize));
    }
}
