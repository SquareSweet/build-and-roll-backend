package me.sqsw.buildandroll.controller;

import lombok.RequiredArgsConstructor;
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
    public List<Weapon> getAll(@RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "10") Integer perPage) {
        return weaponService.getAll(page - 1, perPage);
    }

    @GetMapping()
    public List<Weapon> getByType(@RequestParam String type,
                                  @RequestParam(defaultValue = "1") Integer page,
                                  @RequestParam(defaultValue = "10") Integer perPage) {
        return weaponService.getByType(type, page - 1, perPage);
    }
}
