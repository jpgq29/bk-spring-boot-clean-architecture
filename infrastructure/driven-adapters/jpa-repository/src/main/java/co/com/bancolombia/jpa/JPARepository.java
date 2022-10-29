package co.com.bancolombia.jpa;

import co.com.bancolombia.jpa.entities.ActorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPARepository extends CrudRepository<
        ActorEntity/* change for adapter model */, Long>,
        QueryByExampleExecutor<ActorEntity/* change for adapter model */> {
}
