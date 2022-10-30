package co.com.bancolombia.api;

import co.com.bancolombia.jpa.actor.dto.ActorResponse;
import co.com.bancolombia.jpa.common.IConversion;
import co.com.bancolombia.usecase.actor.ActorUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final ActorUseCase service;
    private final IConversion conversion;

    @GetMapping(path = "/path")
    public List<ActorResponse> commandName() {
        return conversion.listConversion(service.getAll());
    }
}
