package pl.kzapart.covid19map.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class Country {

    private String country;
    private int population;
    private int todayCases;
    private float casesPer;

}
