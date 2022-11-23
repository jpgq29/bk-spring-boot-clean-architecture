package co.com.bancolombia.model.city.gateways;

import co.com.bancolombia.model.city.City;

public interface CityRepository<T,E> {
    T getAll(E pageable);
    City save(City entity);
}
