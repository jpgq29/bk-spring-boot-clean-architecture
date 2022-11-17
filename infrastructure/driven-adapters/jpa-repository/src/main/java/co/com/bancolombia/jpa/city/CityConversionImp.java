package co.com.bancolombia.jpa.city;

import co.com.bancolombia.jpa.city.dto.CityResponseDto;
import co.com.bancolombia.jpa.common.IConversion;
import co.com.bancolombia.model.city.City;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Qualifier("city")
public class CityConversionImp implements IConversion<City, CityResponseDto> {
    @Autowired
    private ObjectMapper mapper;
    @Override
    public List<CityResponseDto> listConversion(List<City> actor) {
        return actor.stream().map(dato -> mapper.map(dato,CityResponseDto.class)).collect(Collectors.toList());
    }

    @Override
    public CityResponseDto conversion(City data) {
        return mapper.map(data,CityResponseDto.class);
    }
}
