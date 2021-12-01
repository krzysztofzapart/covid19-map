package pl.kzapart.covid19map.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.kzapart.covid19map.dto.Country;
import pl.kzapart.covid19map.webclient.cases.CountryClient;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CountryService {

    private final CountryClient countryClient;

    public List<Country> getCoutries() {
        return countryClient.getCoutries();
    }

}
