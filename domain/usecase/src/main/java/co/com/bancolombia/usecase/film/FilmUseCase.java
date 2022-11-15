package co.com.bancolombia.usecase.film;

import co.com.bancolombia.model.film.gateways.FilmRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class FilmUseCase<T, E> {
    private final FilmRepository<T, E> repository;

    public T getAll(E pageable){
        return repository.getAll(pageable);
    }
}
