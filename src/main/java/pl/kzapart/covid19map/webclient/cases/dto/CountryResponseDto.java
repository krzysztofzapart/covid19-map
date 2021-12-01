package pl.kzapart.covid19map.webclient.cases.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CountryResponseDto {

    private String country;
    private int population;
    private CountryCasesDto cases;
    private CountryDeathsDto deaths;
}
