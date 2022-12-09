package com.example.controller;

import com.example.criteriaSearch.CarSpecificationBuilder;
import com.example.model.entity.Car;
import com.example.model.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Controller
@RequiredArgsConstructor
public class SearchController {

    private final CarRepository carRepository;

    @GetMapping(value = "/cars")
    public String newPage() {
        return "cars";
    }

    @PostMapping(value = "/cars")
    public String newPagePost(@RequestParam Map<String, String> allParams, Model model) {
        CarSpecificationBuilder builder = new CarSpecificationBuilder();
        Set<Map.Entry<String, String>> filteredParams = paramFilter(allParams);
        for (Map.Entry<String, String> entry : filteredParams) {
            builder.with(entry.getKey(), entry.getValue());
        }
        Specification<Car> specification = builder.build();
        List<Car> searchedCars = carRepository.findAll(specification);
        model.addAttribute("searchedCars", searchedCars);
        return "cars";
    }


    //этим должен заниматься фронт но увы
    private Set<Map.Entry<String, String>> paramFilter(Map<String, String> allParams) {
        Map<String, String> filteredParams = new HashMap<>();
        for (Map.Entry<String, String> param : allParams.entrySet()) {
            if (param.getKey().contains("_checkbox")) {
                filteredParams.put(
                        param.getKey().replace("_checkbox", ""),
                        allParams.get(param.getKey().replace("_checkbox", ""))
                );
            }
        }
        return filteredParams.entrySet();
    }

}