package me.sqsw.buildandroll.controller;

import lombok.RequiredArgsConstructor;
import me.sqsw.buildandroll.contracts.RoomService;
import me.sqsw.buildandroll.dto.UserDto;
import me.sqsw.buildandroll.dto.request.room.CreateRoomRequest;
import me.sqsw.buildandroll.dto.request.room.UpdateUsersDto;
import me.sqsw.buildandroll.dto.request.room.UserJoinToRoomRequest;
import me.sqsw.buildandroll.dto.response.RoomResponse;
import me.sqsw.buildandroll.model.Room;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @PostMapping("/")
    public ResponseEntity<RoomResponse> create(@RequestBody CreateRoomRequest createRoomRequest) throws Exception {
        return ResponseEntity.ok(new RoomResponse(roomService.create(createRoomRequest.getTitle())));
    }

    @PostMapping("/add_user")
    public void addUser(@RequestBody UserJoinToRoomRequest userJoinToRoomRequest) throws Exception {
        roomService.addUserToRoom(userJoinToRoomRequest);
    }

    @PostMapping("/remove_user")
    public void removeUser(@RequestBody UserJoinToRoomRequest userJoinToRoomRequest) throws Exception {
        roomService.removeUserFromRoom(userJoinToRoomRequest.getUserId(), userJoinToRoomRequest.getRoomId());
    }

    @GetMapping("/all_owned")
    public List<RoomResponse> getRooms() throws Exception {
        List<Room> rooms = roomService.getAllOwned();
        return rooms.stream()
                .map(RoomResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/all")
    public List<RoomResponse> getAllRooms() throws Exception {
        List<Room> rooms = roomService.getAll();
        return rooms.stream()
                .map(RoomResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<RoomResponse> getRoom(@PathVariable Long roomId) throws Exception {
        Room room = roomService.getById(roomId);
        return ResponseEntity.ok(new RoomResponse(room));
    }

    @PostMapping("/{roomId}/send_users")
    public void sendAllUsersInRoom(@PathVariable Long roomId,
                                   @RequestBody UpdateUsersDto users) throws Exception {
        roomService.sendAllUsersInRoom(roomId, users);
    }
}