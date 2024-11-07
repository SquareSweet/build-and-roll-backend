package me.sqsw.buildandroll.controller;

import lombok.RequiredArgsConstructor;
import me.sqsw.buildandroll.dto.WeaponResponse;
import me.sqsw.buildandroll.model.Weapon;
import me.sqsw.buildandroll.service.WeaponService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lib/weapon")
@RequiredArgsConstructor
public class WeaponsController {
    private final WeaponService weaponService;

    @GetMapping("/all")
    public List<WeaponResponse> getAll() {
        return weaponService.getAll();
    }

    @GetMapping()
    public List<WeaponResponse> getByType(@RequestParam(required = false) String type,
                                  @RequestParam(required = false) String search,
                                  @RequestParam(defaultValue = "1") Integer page,
                                  @RequestParam(defaultValue = "10") Integer perPage) {
        return weaponService.getFiltered(type, search, page - 1, perPage);
    }
}
