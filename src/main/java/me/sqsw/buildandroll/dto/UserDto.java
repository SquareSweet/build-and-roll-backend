package me.sqsw.buildandroll.dto;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.sqsw.buildandroll.model.User;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String username;
    @Nullable
    private Long characterListId;
    
    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }

    public void setCharacterListId(@Nullable Long characterListId) {
        this.characterListId = characterListId;
    }
}