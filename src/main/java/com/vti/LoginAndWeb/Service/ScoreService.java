package com.vti.LoginAndWeb.Service;

import com.vti.LoginAndWeb.Entity.Score;
import com.vti.LoginAndWeb.Form.ScoreFilterForm;
import com.vti.LoginAndWeb.Form.ScoreUpdateForm;
import com.vti.LoginAndWeb.Form.ScoreCreateForm;
import com.vti.LoginAndWeb.Form.ScoreUpdateForm;
import com.vti.LoginAndWeb.dto.ScoreDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ScoreService {
    ScoreDto create(ScoreCreateForm form,Long id);

    Page<ScoreDto> findByUserId(Pageable pageable, Long id);

    Page<ScoreDto> findAll(ScoreFilterForm form,Pageable pageable);

    ScoreDto update(ScoreUpdateForm form,Long id);

    ScoreDto findById(Long id);


}
