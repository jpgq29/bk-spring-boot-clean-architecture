package co.com.bancolombia.jpa.actor.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ActorRequest {
    @NotNull(message = "actor_id no puede ser vacio")
    private Long actorId;
    @NotBlank(message = "first_name no puede ser vacio")
    private String firstName;
    @NotBlank(message = "last_name no puede ser vacio")
    private String lastName;
}
