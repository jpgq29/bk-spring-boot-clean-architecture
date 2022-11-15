package co.com.bancolombia.film;

import co.com.bancolombia.jpa.common.IConversion;
import co.com.bancolombia.jpa.film.dto.FilmResponse;
import co.com.bancolombia.model.film.Film;
import co.com.bancolombia.usecase.film.FilmUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@ResponseBody
@RequestMapping(value = "/film", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class FilmRest {
    @Autowired
    private final FilmUseCase<Page<Film>, Pageable> service;
    @Autowired
    @Qualifier("film")
    private final IConversion conversion;

    @GetMapping
    public Page<FilmResponse> commandName(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "3") int size) {
        Pageable pageable = PageRequest.of(page,size);
        return service.getAll(pageable).map(dato -> (FilmResponse)conversion.conversion(dato));
        //return service.getAll(pageable);
    }

}
