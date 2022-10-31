package co.com.bancolombia.jpa.actor;

import co.com.bancolombia.jpa.entities.ActorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.transaction.annotation.Transactional;

public interface JpaActorRepository extends CrudRepository<
        ActorEntity/* change for adapter model */, Long>,
        QueryByExampleExecutor<ActorEntity/* change for adapter model */> {

    @Transactional(readOnly = true)
    Page<ActorEntity> findAll(Pageable pageable);
}
