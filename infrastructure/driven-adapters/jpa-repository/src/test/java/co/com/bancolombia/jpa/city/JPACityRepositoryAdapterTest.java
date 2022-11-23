package co.com.bancolombia.jpa.city;

import co.com.bancolombia.jpa.city.projections.ICityProjection;
import co.com.bancolombia.jpa.city.projections.ICountryProjection;
import co.com.bancolombia.model.city.City;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
class JPACityRepositoryAdapterTest {

    @Mock
    JpaCityRepository repository;

    @Mock
    ObjectMapper mapper;

    @InjectMocks
    JPACityRepositoryAdapter service;
    


    @Test
    void getAll() {
        City city = new City().toBuilder().cityId(33L).city("Bucaramanga").build();
        ICityProjection projection = new ICityProjection() {
            @Override
            public Long getCityId() {
                return 33L;
            }

            @Override
            public String getCity() {
                return "Bucaramanga";
            }

            @Override
            public Date getLastUpdate() {
                return null;
            }

            @Override
            public ICountryProjection getCountry() {
                return null;
            }
        };
        List<ICityProjection> listaICityProjection = new ArrayList<>();
        listaICityProjection.add(projection);

        Page<ICityProjection> pageICityProjection = new PageImpl<>(listaICityProjection);

        List<City> listaCity = new ArrayList<>();
        listaCity.add(city);

        when(repository.findAllBy(any(), eq(ICityProjection.class))).thenReturn(pageICityProjection);
        when(mapper.map(any(),eq(City.class))).thenReturn(city);

        Pageable pageable = PageRequest.of(0,5);
        Page<City> pageResult = service.getAll(pageable);

        Assertions.assertEquals(projection.getCity(), pageResult.getContent().get(0).getCity());
    }

    @Test
    void save(){
        City city = new City().toBuilder().cityId(33L).city("Bucaramanga").build();

        when(repository.save(any(City.class))).thenReturn(city);

        City response = service.save(city);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(33L,response.getCityId());
    }
}