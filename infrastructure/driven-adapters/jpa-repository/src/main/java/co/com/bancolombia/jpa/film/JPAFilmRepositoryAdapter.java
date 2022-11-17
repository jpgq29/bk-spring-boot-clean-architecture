package co.com.bancolombia.jpa.film;

import co.com.bancolombia.jpa.entities.FilmEntity;
import co.com.bancolombia.jpa.helper.AdapterOperations;
import co.com.bancolombia.model.film.Film;
import co.com.bancolombia.model.film.gateways.FilmRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class JPAFilmRepositoryAdapter extends AdapterOperations<
        Film/* change for domain model */,
        FilmEntity/* change for adapter model */,
        Long,
        JpaFilmRepository>
 implements FilmRepository<Page<Film>, Pageable>
{

    public JPAFilmRepositoryAdapter(JpaFilmRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Film.class/* change for domain model */));
    }

    @Override
    public Page<Film> getAll(Pageable pageable) {
        return super.repository.findAllBy(pageable, FilmEntity.class).map(data -> mapper.map(data,Film.class));
    }
}
