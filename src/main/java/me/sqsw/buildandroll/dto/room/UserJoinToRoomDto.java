package me.sqsw.buildandroll.dto.room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.sqsw.buildandroll.model.User;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class UserJoinToRoomDto {
    private User user;
    private Long roomId;

    public List<Object> toList(){
        return List.of(user, roomId);
    }
}