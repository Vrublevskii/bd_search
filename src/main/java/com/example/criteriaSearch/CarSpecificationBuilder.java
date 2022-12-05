package com.example.criteriaSearch;

import com.example.model.entity.Car;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CarSpecificationBuilder {

    private final List<SearchCriteria> params;
    //sd

    public CarSpecificationBuilder() {
        params = new ArrayList<>();
    }

    public final void with(String key, Object value) {
        params.add(new SearchCriteria(key, value));
    }

    public Specification<Car> build() {
        if (params.size() == 0) {
            return null;
        }

        Specification<Car> result = new CarSpecification(params.get(0));
        for (int i = 1; i < params.size(); i++) {
            result = Specification.where(result).and(new CarSpecification(params.get(i)));
        }
        return result;
    }

}
