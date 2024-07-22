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

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
