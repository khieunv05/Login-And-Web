package com.vti.LoginAndWeb.specification;

import ch.qos.logback.core.util.StringUtil;
import com.vti.LoginAndWeb.Entity.User;
import com.vti.LoginAndWeb.Form.UserFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class UserSpecification {
    public static Specification<User> spec(UserFilterForm form){
        return (root, query, builder) -> {
            var predicates = new ArrayList<Predicate>();
            var search = form.getSearch();
            if(StringUtils.hasText(search)){
                var pattern = "%" + search.trim() + "%";
                var predicate = builder.like(root.get("username"),pattern);
                predicates.add(predicate);
            }
            var minCreatedDate = form.getMinCreatedDate();
            if(minCreatedDate !=null){
                var minCreatedAt = LocalDateTime.of(minCreatedDate, LocalTime.MIN);
                var predicate = builder.greaterThanOrEqualTo(root.get("createdAt"),minCreatedAt);
                predicates.add(predicate);
            }
            var maxCreatedDate = form.getMaxCreatedDate();
            if(maxCreatedDate !=null){
                var maxCreatedAt = LocalDateTime.of(maxCreatedDate,LocalTime.MAX);
                var predicate = builder.lessThanOrEqualTo(root.get("createdAt"),maxCreatedAt);
                predicates.add(predicate);
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
