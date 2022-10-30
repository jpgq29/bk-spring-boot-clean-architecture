package co.com.bancolombia.usecase.actor;

import co.com.bancolombia.model.actor.Actor;
import co.com.bancolombia.model.actor.gateways.ActorRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ActorUseCase {
    private final ActorRepository repository;
    public List<Actor> getAll(){
        return repository.getAll();
    }
    public Actor save(Actor actor){return repository.save(actor);}
}
