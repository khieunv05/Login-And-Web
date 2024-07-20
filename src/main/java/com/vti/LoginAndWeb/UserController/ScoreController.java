package com.vti.LoginAndWeb.UserController;

import com.vti.LoginAndWeb.Form.ScoreCreateForm;
import com.vti.LoginAndWeb.Service.ScoreService;
import com.vti.LoginAndWeb.dto.ScoreDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor

public class ScoreController {
    private final ScoreService scoreService;
    @PostMapping("/api/v1/scores")
    public ScoreDto create(@RequestBody ScoreCreateForm form){
        return scoreService.create(form);
    }

    @GetMapping("/api/v1/scores")
    public Page<ScoreDto> findAll(Pageable pageable){
        return scoreService.findAll(pageable);
    }
}
