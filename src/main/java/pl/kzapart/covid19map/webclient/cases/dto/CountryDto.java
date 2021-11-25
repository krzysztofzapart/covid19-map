package pl.kzapart.covid19map.webclient.cases.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CountryDto {

    private List<CountryResponseDto> response;
}
