package com.vti.LoginAndWeb.Service;

import com.vti.LoginAndWeb.Entity.Score;
import com.vti.LoginAndWeb.Form.ScoreCreateForm;
import com.vti.LoginAndWeb.Form.ScoreUpdateForm;
import com.vti.LoginAndWeb.Repository.ScoreRepository;
import com.vti.LoginAndWeb.Repository.UserRepository;
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
    private final UserRepository userRepository;
    @Override
    public ScoreDto create(ScoreCreateForm form,Long id) {
        var score = ScoreMapper.map(form);
        score.setUser(userRepository.findById(id).get());
        var savedScore = scoreRepository.save(score);
        return ScoreMapper.map(savedScore);
    }

    @Override
    public Page<ScoreDto> findAllByUserId(Pageable pageable,Long id) {
        return scoreRepository.findByUserId(id,pageable).map(ScoreMapper::map);
    }

    @Override
    public ScoreDto update(ScoreUpdateForm form, Long id) {
        var newScore = scoreRepository.findById(id).get();
        var score = ScoreMapper.map(form,newScore);
        var savedScore = scoreRepository.save(score);
        return ScoreMapper.map(savedScore);
    }


}
