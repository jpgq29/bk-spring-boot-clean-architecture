package co.com.bancolombia.jpa.city.projections;


import java.util.Date;

public interface ICountryProjection {
    Long getCountryId();
    String getCountry();
    Date getLastUpdate();
}
