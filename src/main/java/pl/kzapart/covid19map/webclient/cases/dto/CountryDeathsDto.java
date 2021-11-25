package pl.kzapart.covid19map.webclient.cases.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CountryDeathsDto {

    @JsonProperty("new")
    private String dailyDeaths;
}
