package co.com.bancolombia.api;

import co.com.bancolombia.jpa.actor.dto.ActorRequest;
import co.com.bancolombia.jpa.actor.dto.ActorResponse;
import co.com.bancolombia.jpa.common.IConversion;
import co.com.bancolombia.model.actor.Actor;
import co.com.bancolombia.usecase.actor.ActorUseCase;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@ResponseBody
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final ActorUseCase<Page<Actor>, Pageable> service;

    private final IConversion conversion;

    @GetMapping
    public Page<ActorResponse> commandName(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "3") int size) {
        Pageable pageable = PageRequest.of(page,size);
        return service.getAll(pageable).map(dato -> (ActorResponse)conversion.conversion(dato));
    }

    @PostMapping
    public ResponseEntity<String> save(@Valid @RequestBody ActorRequest actor){
        return ResponseEntity.ok("Pasa");
    }
}
