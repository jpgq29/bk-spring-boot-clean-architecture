package co.com.bancolombia.jpa.actor.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ActorResponse {
    private Long actorId;
    private String firstName;
    private String lastName;
    private Date lastUpdate;
}
