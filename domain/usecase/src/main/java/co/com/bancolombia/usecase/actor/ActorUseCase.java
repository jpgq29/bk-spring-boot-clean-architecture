package co.com.bancolombia.usecase.actor;

import co.com.bancolombia.model.actor.Actor;
import co.com.bancolombia.model.actor.gateways.ActorRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ActorUseCase<T, E> {
    private final ActorRepository<T, E> repository;
    public T getAll(E pageable){
        System.out.println(repository.getAll(pageable));
        return repository.getAll(pageable);
    }
    public Actor save(Actor actor){return repository.save(actor);}
}
