package com.vti.LoginAndWeb.UserController;

import com.vti.LoginAndWeb.Entity.Score;
import com.vti.LoginAndWeb.Form.ScoreCreateForm;
import com.vti.LoginAndWeb.Form.ScoreFilterForm;
import com.vti.LoginAndWeb.Form.ScoreUpdateForm;
import com.vti.LoginAndWeb.Service.ScoreService;
import com.vti.LoginAndWeb.dto.ScoreDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@AllArgsConstructor

public class ScoreController {
    private final ScoreService scoreService;
    @PostMapping("/api/v1/{userId}/scores")
    public ScoreDto create(@RequestBody @Valid ScoreCreateForm form, @PathVariable("userId") Long id){
        return scoreService.create(form,id);
    }

    @GetMapping("/api/v1/{userId}/scores")
    public Page<ScoreDto> findByUserId(Pageable pageable, @PathVariable("userId") Long id){
        return scoreService.findByUserId(pageable,id);
    }
    @GetMapping("/api/v1/scores")
    public Page<ScoreDto> findAll(ScoreFilterForm form,Pageable pageable){
        return scoreService.findAll(form,pageable);
    }

    @PutMapping("/api/v1/scores/{id}")
    public ScoreDto update(@RequestBody @Valid ScoreUpdateForm form,@PathVariable Long id){
        return scoreService.update(form,id);
    }
}
