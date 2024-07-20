package com.vti.LoginAndWeb.Repository;

import com.vti.LoginAndWeb.Entity.Score;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score,Long> {
    Page<Score> findByUserId(Long id, Pageable pageable);
}
