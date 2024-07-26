package com.vti.LoginAndWeb.Repository;

import com.vti.LoginAndWeb.Entity.Score;
import com.vti.LoginAndWeb.Form.ScoreFilterForm;
import com.vti.LoginAndWeb.specification.ScoreSpecification;
import org.springframework.boot.autoconfigure.rsocket.RSocketProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Long>, JpaSpecificationExecutor<Score> {
    Page<Score> findByUserId(Long id, Pageable pageable);

}
