package co.com.bancolombia.city;

import co.com.bancolombia.jpa.city.dto.CityResponseDto;
import co.com.bancolombia.jpa.common.IConversion;
import co.com.bancolombia.model.city.City;
import co.com.bancolombia.usecase.city.CityUseCase;
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
@RequestMapping(value = "/city", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class CityRest {
    @Autowired
    private final CityUseCase<Page<City>, Pageable> service;

    @Autowired
    @Qualifier("city")
    private final IConversion conversion;

    @GetMapping
    public Page<CityResponseDto> commandName(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "3") int size) {
        Pageable pageable = PageRequest.of(page,size);
        return service.getAll(pageable).map(data -> (CityResponseDto)conversion.conversion(data));
    }

}
