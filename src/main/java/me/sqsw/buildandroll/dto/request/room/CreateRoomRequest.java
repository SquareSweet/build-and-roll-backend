package me.sqsw.buildandroll.dto.request.room;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CreateRoomRequest {
    private String title;

    @JsonCreator
    public CreateRoomRequest(@JsonProperty("title") String title) {
        this.title = title;
    }
}