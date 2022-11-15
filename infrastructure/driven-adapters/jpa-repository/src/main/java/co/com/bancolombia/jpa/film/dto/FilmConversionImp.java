package co.com.bancolombia.jpa.film.dto;

import co.com.bancolombia.jpa.common.IConversion;
import co.com.bancolombia.model.film.Film;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Qualifier("film")
public class FilmConversionImp implements IConversion<Film, FilmResponse> {
    @Autowired
    private ObjectMapper mapper;
    @Override
    public List<FilmResponse> listConversion(List<Film> film) {
        return film.stream().map(dato -> mapper.map(dato,FilmResponse.class)).collect(Collectors.toList());
    }

    @Override
    public FilmResponse conversion(Film data) {
        return mapper.map(data, FilmResponse.class);
    }
}
