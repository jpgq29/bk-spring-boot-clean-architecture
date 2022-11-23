package co.com.bancolombia.jpa.city;

import co.com.bancolombia.jpa.entities.CityEntity;
import co.com.bancolombia.model.city.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.transaction.annotation.Transactional;

public interface JpaCityRepository extends CrudRepository<
        CityEntity/* change for adapter model */, Long>,
        QueryByExampleExecutor<CityEntity/* change for adapter model */> {

    @Transactional(readOnly = true)
    <T> Page<T> findAllBy(Pageable pageable, Class<T> type);

    City save(City entity);
}
