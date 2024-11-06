package me.sqsw.buildandroll.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.sqsw.buildandroll.dto.UserDto;
import me.sqsw.buildandroll.model.Room;
import me.sqsw.buildandroll.model.User;

@Getter
@Setter
@AllArgsConstructor
public class RoomResponse {

    private String title;

    private UserDto owner;

    private String invitationLink;

    public RoomResponse(Room room) {
        this.title = room.getTitle();
        this.owner = new UserDto(room.getOwner());
        this.invitationLink = room.getInvitationLink();
    }
}