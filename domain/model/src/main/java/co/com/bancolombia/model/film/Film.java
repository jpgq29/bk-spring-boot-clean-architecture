package co.com.bancolombia.model.film;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Film {
    private Long filmId;
    private String title;
    private String description;
    private Integer releaseYear;
}
