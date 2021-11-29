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
    private static final String COUNTRIES_URL = "https://covid-193.p.rapidapi.com/statistics";

    public List<Country> getCoutries() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-host", "covid-193.p.rapidapi.com");
        headers.set("x-rapidapi-key",System.getenv("API_KEY"));
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<CountryDto> response = restTemplate.exchange(COUNTRIES_URL, HttpMethod.GET, entity, CountryDto.class);
        CountryDto country = response.getBody();

        List<Country> countries = new LinkedList<>();
        for(int i=0; i<country.getResponse().size();i++ )
        {
            countries.add(Country.builder()
                    .country(country.getResponse().get(i).getCountry())
                    .population(country.getResponse().get(i).getPopulation())
                    .dailyCases(castDailyCases(country.getResponse().get(i).getCases().getDailyCases()))
                    .dailyDeaths(castDailyCases(country.getResponse().get(i).getDeaths().getDailyDeaths()))
                    .casesPer(calculatePer100k(country.getResponse().get(i).getPopulation(),castDailyCases(country.getResponse().get(i).getCases().getDailyCases())))
                    .death(castDailyCases(country.getResponse().get(i).getDeaths().getDailyDeaths()))
                    .build());
        }
        return countries;
    }

    private int castDailyCases(String dailyCases) {
        if(dailyCases==null)
            return 0;
        else
        {
           String temp = dailyCases.substring(1);
           return Integer.parseInt(temp);
        }

    }

    private int calculatePer100k(int population, int todayCases)
    {
        long cases=0L;
        if (population==0)
            return (int) (cases = 0);
        else
        {
            long x = todayCases* 100000L;
            long y = x/population;
            return (int) y;
        }




    }
}
