package co.com.bancolombia.jpa.actor;

import co.com.bancolombia.jpa.entities.ActorEntity;
import co.com.bancolombia.jpa.helper.AdapterOperations;
import co.com.bancolombia.model.actor.Actor;
import co.com.bancolombia.model.actor.gateways.ActorRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class JPAActorRepositoryAdapter extends AdapterOperations<
        Actor/* change for domain model */,
        ActorEntity/* change for adapter model */,
        Long,
        JpaActorRepository>
 implements ActorRepository<Page<Actor>, Pageable>
{

    public JPAActorRepositoryAdapter(JpaActorRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Actor.class/* change for domain model */));
    }

    @Override
    public Page<Actor> getAll(org.springframework.data.domain.Pageable pageable) {
        return super.repository.findAll(pageable).map(data -> mapper.map(data,Actor.class));
    }
}
