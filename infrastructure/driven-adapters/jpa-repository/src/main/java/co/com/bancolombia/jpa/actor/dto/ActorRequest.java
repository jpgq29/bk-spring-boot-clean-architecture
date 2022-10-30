package co.com.bancolombia.jpa.actor.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ActorRequest {
    @JsonAlias("Id")
    @NotNull(message = "Id no puede ser vacio")
    private Long actorId;
    @NotBlank(message = "first_name no puede ser vacio")
    private String firstName;
    @NotBlank(message = "last_name no puede ser vacio")
    private String lastName;
}
