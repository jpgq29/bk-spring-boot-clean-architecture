package co.com.bancolombia.model.film.gateways;

public interface FilmRepository<T, E> {
    T getAll(E pageable);
}
