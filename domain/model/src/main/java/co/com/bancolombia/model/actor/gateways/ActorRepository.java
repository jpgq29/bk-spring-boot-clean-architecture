package co.com.bancolombia.model.actor.gateways;

import co.com.bancolombia.model.actor.Actor;

import java.util.List;

public interface ActorRepository {
    List<Actor> getAll();
}
