package me.sqsw.buildandroll.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "characters_stats")
@EqualsAndHashCode(exclude = "level")
@AllArgsConstructor
@NoArgsConstructor
public class CharacterStat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "character_id")
    private Long characterId;
    @Column(name = "stat_id")
    private Integer statId;
    private Integer level;
}
