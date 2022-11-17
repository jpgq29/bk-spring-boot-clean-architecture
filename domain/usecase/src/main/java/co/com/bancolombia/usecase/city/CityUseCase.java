package co.com.bancolombia.usecase.city;

import co.com.bancolombia.model.city.gateways.CityRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CityUseCase<T, E> {
    private final CityRepository<T, E> repository;
    public T getAll(E pageable){
        return repository.getAll(pageable);
    }
}
