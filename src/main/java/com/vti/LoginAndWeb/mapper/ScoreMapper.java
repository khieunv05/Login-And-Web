package com.vti.LoginAndWeb.mapper;

import com.vti.LoginAndWeb.Entity.Score;
import com.vti.LoginAndWeb.Form.ScoreCreateForm;
import com.vti.LoginAndWeb.Form.ScoreUpdateForm;
import com.vti.LoginAndWeb.dto.ScoreDto;

public class ScoreMapper {
    public static Score map(ScoreCreateForm form){
        var score = new Score();
        score.setSubjectName(form.getName_subject());
        score.setScore(form.getScore());
        score.setScore(form.getScore());
        return score;
    }
    public static ScoreDto map(Score score){
        var scoreDto = new ScoreDto();
        scoreDto.setId(score.getId());
        scoreDto.setSubjectName(score.getSubjectName());
        scoreDto.setScore(score.getScore());
        scoreDto.setCreatedAt(score.getCreatedAt());
        scoreDto.setUpdatedAt(score.getUpdatedAt());
        scoreDto.setId(score.getId());
        return scoreDto.withSelfRel();
    }
    public static Score map(ScoreUpdateForm form){
        var score = new Score();
        score.setSubjectName(form.getName_subject());
        score.setScore(form.getScore());
        score.setScore(form.getScore());
        return score;
    }
    public static Score map(ScoreUpdateForm form, Score score){
        score.setSubjectName(form.getName_subject());
        score.setUser(score.getUser());
        score.setScore(form.getScore());
        return score;
    }
}
