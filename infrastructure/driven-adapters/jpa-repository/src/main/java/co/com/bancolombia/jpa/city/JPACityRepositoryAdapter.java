package co.com.bancolombia.jpa.city;

import co.com.bancolombia.jpa.city.projections.ICityProjection;
import co.com.bancolombia.jpa.entities.CityEntity;
import co.com.bancolombia.jpa.helper.AdapterOperations;
import co.com.bancolombia.model.city.City;
import co.com.bancolombia.model.city.gateways.CityRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class JPACityRepositoryAdapter extends AdapterOperations<
        City/* change for domain model */,
        CityEntity/* change for adapter model */,
        Long,
        JpaCityRepository>
 implements CityRepository<Page<City>, Pageable>
{

    public JPACityRepositoryAdapter(JpaCityRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, City.class/* change for domain model */));
    }


    @Override
    public Page<City> getAll(Pageable pageable) {
        return super.repository.findAllBy(pageable, ICityProjection.class).map(data -> mapper.map(data, City.class));
    }
}
