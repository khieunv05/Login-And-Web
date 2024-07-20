package com.vti.LoginAndWeb.Service;

import com.vti.LoginAndWeb.Entity.Score;
import com.vti.LoginAndWeb.Form.ScoreCreateForm;
import com.vti.LoginAndWeb.Repository.ScoreRepository;
import com.vti.LoginAndWeb.dto.ScoreDto;
import com.vti.LoginAndWeb.mapper.ScoreMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ScoreServiceImp implements ScoreService{
    private final ScoreRepository scoreRepository;
    @Override
    public ScoreDto create(ScoreCreateForm form) {
        var score = ScoreMapper.map(form);
        var savedScore = scoreRepository.save(score);
        return ScoreMapper.map(savedScore);
    }

    @Override
    public Page<ScoreDto> findAll(Pageable pageable) {
        return scoreRepository.findAll(pageable).map(ScoreMapper::map);
    }
}
