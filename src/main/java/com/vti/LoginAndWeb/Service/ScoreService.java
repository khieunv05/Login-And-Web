package com.vti.LoginAndWeb.Service;

import com.vti.LoginAndWeb.Form.ScoreCreateForm;
import com.vti.LoginAndWeb.dto.ScoreDto;

public interface ScoreService {
    public ScoreDto create(ScoreCreateForm form);
}
