package co.com.bancolombia.model.city.gateways;

public interface CityRepository<T,E> {
    T getAll(E pageable);
}
