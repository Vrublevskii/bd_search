package com.example.criteriaSearch;

import com.example.model.entity.Car;
import com.example.model.entity.Driver;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.lang.reflect.Field;

@SuppressWarnings("SameParameterValue")
@AllArgsConstructor
public class CarSpecification implements Specification<Car> {

    private SearchCriteria searchCriteria;

    @Override
    public Predicate toPredicate(Root<Car> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        if (isSearchCriteriaEqualToClassFields(Driver.class)) {
            return getPredicate(root, criteriaBuilder, "driver");
        } else {
            if (searchCriteria.getValue().equals("")) {
                return criteriaBuilder.isNull(root.get(searchCriteria.getKey()));
            } else if (searchCriteria.getValue().getClass() == String.class) {
                return criteriaBuilder.like(root.get(searchCriteria.getKey()), (String) searchCriteria.getValue());
            } else {
                return criteriaBuilder.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue());
            }
        }
    }

    private boolean isSearchCriteriaEqualToClassFields(Class<?> aClass) {
        for (Field declaredField : aClass.getDeclaredFields()) {
            System.out.println(declaredField);
            if (declaredField.toString().contains("java.lang")) {
                if (searchCriteria.getKey().equals(declaredField.toString()
                        .replaceAll("private java\\.lang\\..+" + aClass.getSimpleName() + "\\.", ""))) {
                    return true;
                }
            }
        }
        return false;
    }

    private Predicate getPredicate(Root<Car> root, CriteriaBuilder criteriaBuilder, String joinTableName) {
        if (searchCriteria.getValue().equals("")) {
            return criteriaBuilder.isNull(root.join(joinTableName).get(searchCriteria.getKey()));
        } else if (root.join(joinTableName).get(searchCriteria.getKey()).getJavaType() == String.class) {
            return criteriaBuilder.
                    like(root.join(joinTableName).
                            get(searchCriteria.getKey()), (String) searchCriteria.getValue()
                    );
        } else {
            return criteriaBuilder.equal(root.join(joinTableName).
                    get(searchCriteria.getKey()), searchCriteria.getValue()
            );
        }
    }

}