package me.sqsw.buildandroll.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "characters_stats")
@EqualsAndHashCode(exclude = "level")
public class CharacterStat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id")
    private Long characterId;
    @Column(name = "stat_id")
    private Integer id;
    private Integer level;
}
