package me.sqsw.buildandroll.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "room")
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private boolean isPrivate;

    @Nullable
    private String invitationLink;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
}

