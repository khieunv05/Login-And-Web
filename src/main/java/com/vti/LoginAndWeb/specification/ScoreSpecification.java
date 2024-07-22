package com.vti.LoginAndWeb.specification;

import com.vti.LoginAndWeb.Entity.Score;
import com.vti.LoginAndWeb.Form.ScoreFilterForm;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

public class ScoreSpecification {
    public static Specification<Score> spec(ScoreFilterForm form){
        return (root,query,builder) ->{
            var predicates = new ArrayList<Predicate>();
            var search = form.getSearch();
            if(StringUtils.hasText(search)){
                var pattern = "%" + search.trim() + "%";
                var predicate = builder.like(root.get("subjectName"),pattern);
                predicates.add(predicate);
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
