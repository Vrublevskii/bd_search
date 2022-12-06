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

        for (Map.Entry<String, String> filteredParam : filteredParams) {
            System.out.println(filteredParam.getKey());
            System.out.println(filteredParam.getValue());
        }

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
        checkParameter(allParams, "id_car");
        checkParameter(allParams, "name");
        checkParameter(allParams, "color");
        checkParameter(allParams, "year");
        checkParameter(allParams, "id_driver");
        checkParameter(allParams, "name_driver");
        checkParameter(allParams, "last_name_driver");
        return allParams.entrySet();
    }

    private void checkParameter(Map<String, String> allParams, String parameter) {
        if (!allParams.containsKey(parameter + "_checkbox")) {
            allParams.remove(parameter);
        } else {
            allParams.remove(parameter + "_checkbox");
        }
    }

}