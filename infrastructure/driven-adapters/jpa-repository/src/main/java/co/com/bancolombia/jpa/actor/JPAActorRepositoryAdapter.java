package co.com.bancolombia.jpa.actor;

import co.com.bancolombia.jpa.entities.ActorEntity;
import co.com.bancolombia.jpa.helper.AdapterOperations;
import co.com.bancolombia.model.actor.Actor;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JPAActorRepositoryAdapter extends AdapterOperations<
        Actor/* change for domain model */,
        ActorEntity/* change for adapter model */,
        Long,
        JpaActorRepository>
// implements ModelRepository from domain
{

    public JPAActorRepositoryAdapter(JpaActorRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Actor.class/* change for domain model */));
    }
}
