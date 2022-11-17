package co.com.bancolombia.model.country;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Country {
    private Long countryId;
    private String country;
    private Date lastUpdate;
}