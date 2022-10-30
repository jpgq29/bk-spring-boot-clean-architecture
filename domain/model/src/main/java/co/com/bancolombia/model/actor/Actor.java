package co.com.bancolombia.model.actor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Actor {
    private Long actorId;
    private String firstName;
    private String lastName;
    private Date lastUpdate;
}
