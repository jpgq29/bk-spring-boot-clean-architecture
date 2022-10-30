package co.com.bancolombia.jpa.actor;

import co.com.bancolombia.jpa.entities.ActorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JpaActorRepository extends CrudRepository<
        ActorEntity/* change for adapter model */, Long>,
        QueryByExampleExecutor<ActorEntity/* change for adapter model */> {
}
