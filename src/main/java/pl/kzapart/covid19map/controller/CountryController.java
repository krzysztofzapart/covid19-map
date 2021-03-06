package pl.kzapart.covid19map.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kzapart.covid19map.dto.Country;
import pl.kzapart.covid19map.service.CountryService;

import java.util.List;

@Controller
@AllArgsConstructor
public class CountryController {

    private CountryService countryService;
    @GetMapping("/countries")
    public List<Country> getCountries()
    {
        return countryService.getCoutries();
    }
    @GetMapping
    public String getMap(Model model)
    {
        model.addAttribute("countries", countryService.getCoutries());
        return "map";
    }

    @GetMapping("/deaths")
    public String getDeaths(Model model)
    {
        model.addAttribute("countries", countryService.getCoutries());
        return "deaths";
    }

}
