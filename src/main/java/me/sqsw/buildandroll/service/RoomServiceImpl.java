package me.sqsw.buildandroll.service;

import com.pusher.rest.Pusher;
import lombok.RequiredArgsConstructor;
import me.sqsw.buildandroll.contracts.RoomService;
import me.sqsw.buildandroll.dto.UserDto;
import me.sqsw.buildandroll.dto.request.room.UpdateUsersDto;
import me.sqsw.buildandroll.dto.response.RoomResponse;
import me.sqsw.buildandroll.dto.room.UserJoinToRoomDto;
import me.sqsw.buildandroll.enums.RoomEvents;
import me.sqsw.buildandroll.model.Room;
import me.sqsw.buildandroll.model.User;
import me.sqsw.buildandroll.repository.RoomRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final UserService userService;
    private final Pusher pusher;

    @Override
    public Room create(String title) {
        Room room = new Room();
        room.setTitle(title);
        String userName = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Optional<User> user = userService.getByUsername(userName);
        room.setOwner(user.get());
        room.setInvitationLink("http://exampleLink");
        return roomRepository.save(room);
    }

    public List<Room> getAllOwned() throws Exception {
        String userName = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Optional<User> user = userService.getByUsername(userName);
        return roomRepository.findByOwner(user.get());
    }

    public List<Room> getAll() throws Exception {
        return (List<Room>) roomRepository.findAll();
    }

    @Override
    public Optional<Room> getByTitle(String title) {
        return Optional.empty();
    }

    public Room getById(Long id) {
        Optional<Room> room = roomRepository.getById(id);
        if(room.isPresent()){
            return room.get();
        }else{
            throw new IllegalArgumentException("Room not found");
        }
    }

    public void addUserToRoom(Long userId, Long roomId) throws Exception {
        Optional<User> user = userService.getById(userId);
        user.ifPresent(value -> pusher.trigger("room_" + roomId.toString() + "_channel", RoomEvents.USER_JOINED.toString(), new UserJoinToRoomDto(value, roomId)));
    }

    public void sendAllUsersInRoom(Long roomId, UpdateUsersDto users) {
        pusher.trigger("room_" + roomId.toString() + "_channel", RoomEvents.UPDATE_USERS.toString(), users);
    }

    public void removeUserFromRoom(Long userId, Long roomId) {
        Optional<User> user = userService.getById(userId);
        user.ifPresent(value -> pusher.trigger("room_" + roomId.toString() + "_channel", RoomEvents.USER_LEFT.toString(), new UserJoinToRoomDto(value, roomId)));
    }
}
