package pl.kzapart.covid19map.webclient.cases.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CountryDataDto {

    private String country;
    private int todayCases;
    private int population;
}
