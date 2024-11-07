package me.sqsw.buildandroll.dto.room;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.sqsw.buildandroll.dto.UserDto;
import me.sqsw.buildandroll.model.User;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class UserJoinToRoomDto {
    private UserDto user;
    private Long roomId;

    public UserJoinToRoomDto(User user, Long roomId) {
        this.user = new UserDto(user);
        this.roomId = roomId;
    }

    public void setCharacterListId(Long characterListId) {
        this.user.setCharacterListId(characterListId);
    }

    public List<Object> toList(){
        return List.of(user, roomId);
    }
}