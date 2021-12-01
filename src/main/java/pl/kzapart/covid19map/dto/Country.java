package pl.kzapart.covid19map.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class Country {

    private int dailyDeaths;
    private int dailyCases;
    private int casesPer;
    private String country;
    private int population;
    private int death;
}
