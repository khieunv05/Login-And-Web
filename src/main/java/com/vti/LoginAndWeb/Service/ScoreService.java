package com.vti.LoginAndWeb.Service;

import com.vti.LoginAndWeb.Form.ScoreCreateForm;
import com.vti.LoginAndWeb.dto.ScoreDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ScoreService {
    ScoreDto create(ScoreCreateForm form);

    Page<ScoreDto> findAll(Pageable pageable);
}
