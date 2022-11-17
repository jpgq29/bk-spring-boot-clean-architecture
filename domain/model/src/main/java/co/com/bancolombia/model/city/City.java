package co.com.bancolombia.model.city;

import co.com.bancolombia.model.country.Country;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class City {
    private Long cityId;
    private String city;
    private Country country;
    private Date lastUpdate;
}
