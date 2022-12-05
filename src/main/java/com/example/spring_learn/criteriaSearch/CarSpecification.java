package com.example.spring_learn.criteriaSearch;

import com.example.spring_learn.model.entity.Car;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@AllArgsConstructor
public class CarSpecification implements Specification<Car> {

    private SearchCriteria searchCriteria;

    @Override
    public Predicate toPredicate(Root<Car> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        if (searchCriteria.getValue().equals("")) {
            return criteriaBuilder.isNull(root.get(searchCriteria.getKey()));
        } else if (root.get(searchCriteria.getKey()).getJavaType() == String.class) {
            return criteriaBuilder.like(root.get(searchCriteria.getKey()), (String) searchCriteria.getValue());
        } else {
            return criteriaBuilder.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue());
        }

    }
}
