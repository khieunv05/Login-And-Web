package com.vti.LoginAndWeb.UserController;

import com.vti.LoginAndWeb.Form.ScoreCreateForm;
import com.vti.LoginAndWeb.Form.ScoreUpdateForm;
import com.vti.LoginAndWeb.Service.ScoreService;
import com.vti.LoginAndWeb.dto.ScoreDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor

public class ScoreController {
    private final ScoreService scoreService;
    @PostMapping("/api/v1/{userId}/scores")
    public ScoreDto create(@RequestBody ScoreCreateForm form,@PathVariable("userId") Long id){
        return scoreService.create(form,id);
    }

    @GetMapping("/api/v1/{userId}/scores")
    public Page<ScoreDto> findAllByUserId(Pageable pageable,@PathVariable("userId") Long id){
        return scoreService.findAllByUserId(pageable,id);
    }

    @PutMapping("/api/v1/scores/{id}")
    public ScoreDto update(@RequestBody ScoreUpdateForm form,@PathVariable Long id){
        return scoreService.update(form,id);
    }
}
