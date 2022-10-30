package co.com.bancolombia.jpa.actor;

import co.com.bancolombia.model.actor.Actor;
import co.com.bancolombia.model.actor.gateways.ActorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class JpaActorImpl implements ActorRepository {

    private JPAActorRepositoryAdapter repository;
    @Override
    public List<Actor> getAll() {
        return repository.findAll();
    }
    @Override
    public Actor save(Actor actor) {
        return repository.save(actor);
    }
}
