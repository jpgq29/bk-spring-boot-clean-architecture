package co.com.bancolombia.jpa.city.projections;

import java.util.Date;

public interface ICityProjection {
    Long getCityId();
    String getCity();
    Date getLastUpdate();
    ICountryProjection getCountry();
}
