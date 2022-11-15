package co.com.bancolombia.jpa.film;

import co.com.bancolombia.jpa.entities.FilmEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.transaction.annotation.Transactional;

public interface JpaFilmRepository extends CrudRepository<
        FilmEntity/* change for adapter model */, Long>,
        QueryByExampleExecutor<FilmEntity/* change for adapter model */> {

    @Transactional(readOnly = true)
    Page<FilmEntity> findAll(Pageable pageable);
}
