package com.example.spring_learn.controller;

import com.example.spring_learn.criteriaSearch.CarSpecificationBuilder;
import com.example.spring_learn.model.entity.Car;
import com.example.spring_learn.model.repository.CarRepository;
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
public class CarController {

    private final CarRepository carRepository;

    @GetMapping(value = "/cars")
    public String newPage() {
        return "cars";
    }

    @PostMapping(value = "/cars")
    public String newPagePost(@RequestParam Map<String, String> allParams, Model model) {
        CarSpecificationBuilder builder = new CarSpecificationBuilder();
        Set<Map.Entry<String, String>> filteredParams = paramFilter(allParams, builder);
        for (Map.Entry<String, String> entry : filteredParams) {
            builder.with(entry.getKey(), entry.getValue());
        }
        Specification<Car> specification = builder.build();
        List<Car> searchedCars = carRepository.findAll(specification);
        model.addAttribute("searchedCars", searchedCars);
        return "cars";
    }


    //этим должен заниматься фронт но увы
    private Set<Map.Entry<String, String>> paramFilter(Map<String, String> allParams, CarSpecificationBuilder builder) {
        checkParameter(allParams, "id");
        checkParameter(allParams, "name");
        checkParameter(allParams, "color");
        checkParameter(allParams, "year");
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