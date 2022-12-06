package com.example.criteriaSearch;

import com.example.model.entity.Car;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

@AllArgsConstructor
public class CarSpecification implements Specification<Car> {

    private SearchCriteria searchCriteria;

    @Override
    public Predicate toPredicate(Root<Car> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        if (searchCriteria.getValue().equals("")) {
            if (searchCriteria.getKey().equals("name_driver")
                    || searchCriteria.getKey().equals("last_name_driver")
                    || searchCriteria.getKey().equals("id_driver")
            ) {
                return criteriaBuilder.isNull(root.join("driver").get(searchCriteria.getKey()));
            }
            return criteriaBuilder.isNull(root.get(searchCriteria.getKey()));
        } else if (searchCriteria.getKey().equals("name_driver") || searchCriteria.getKey().equals("last_name_driver")) {
            return criteriaBuilder.like(root.join("driver").get(searchCriteria.getKey()), (String) searchCriteria.getValue());
        } else if (searchCriteria.getKey().equals("id_driver")) {
            return criteriaBuilder.equal(root.join("driver").get(searchCriteria.getKey()), searchCriteria.getValue());
        } else if (root.get(searchCriteria.getKey()).getJavaType() == String.class) {
            return criteriaBuilder.like(root.get(searchCriteria.getKey()), (String) searchCriteria.getValue());
        } else {
            return criteriaBuilder.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue());
        }
    }

}