package co.com.bancolombia.model.actor.gateways;

import co.com.bancolombia.model.actor.Actor;

public interface ActorRepository<T, E> {
    T getAll(E pageable);
    Actor save(Actor actor);
}
