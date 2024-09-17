package com.covid.app.covid_app.service;

import com.covid.app.covid_app.Utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class CovidDataService {

    @Autowired
    RestTemplate restTemplate;

    public Integer getDataService(String cityName) {
        // Fetch the data from the COVID API
        Map<String, Object> response = restTemplate.getForObject(Util.COVID_DATA, Map.class);

        Map<String, Object> data = (Map<String, Object>) response.get("data");
//        Map<String, Object> statewise = (Map<String, Object>) data.get("statewise");

        List<Map<String, Object>> statewise = (List<Map<String, Object>>) data.get("statewise");

        for (Map<String, Object> stateData : statewise) {
            // Check if the state matches the provided cityName
            String stateName = (String) stateData.get("state");
            if (stateName.equalsIgnoreCase(cityName)) {
                // Return the "active" cases for the matching state
                return (Integer) stateData.get("active");
            }
        }
        return 0;
    }
}
