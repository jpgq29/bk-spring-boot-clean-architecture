package co.com.bancolombia.jpa.actor.dto;

import lombok.Data;

@Data
public class ActorRequest {
    private Long actorId;
    private String firstName;
    private String lastName;
}
