package pl.kzapart.covid19map.webclient.cases;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.kzapart.covid19map.dto.Country;
import pl.kzapart.covid19map.webclient.cases.dto.CountryDto;

import java.util.LinkedList;
import java.util.List;

@Component
@AllArgsConstructor
public class CountryClient {

    private final RestTemplate restTemplate;
    private static final String COUNTRIES_URL = "https://covid-19-v1.p.rapidapi.com/v1/countries";

    public List<Country> getCoutries() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-host", "covid-19-v1.p.rapidapi.com");
        headers.set("x-rapidapi-key",System.getenv("API_KEY"));
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<CountryDto> response = restTemplate.exchange(COUNTRIES_URL, HttpMethod.GET, entity, CountryDto.class);
        CountryDto country = response.getBody();

        List<Country> countries = new LinkedList<>();
        for(int i=0; i<country.getData().size();i++ )
        {
            countries.add(Country.builder()
                    .country(country.getData().get(i).getCountry())
                    .todayCases(country.getData().get(i).getTodayCases())
                    .population(country.getData().get(i).getPopulation())
                    .casesPer(calculatePer100k(country.getData().get(i).getPopulation(), country.getData().get(i).getTodayCases()))
                    .build());
        }
        return countries;
    }
    private float calculatePer100k(int population, int todayCases)
    {
        float cases;
        if (population==0)
            return cases = 0;
        else
            return cases = (todayCases*100000)/population;

    }
}
