package co.com.bancolombia.jpa;

import co.com.bancolombia.jpa.JPARepositoryAdapter;
import co.com.bancolombia.model.actor.Actor;
import co.com.bancolombia.model.actor.gateways.ActorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class JpaActorImpl implements ActorRepository {

    private JPARepositoryAdapter jpaRepositoryAdapter;
    @Override
    public List<Actor> getAll() {
        return jpaRepositoryAdapter.findAll();
    }
}
