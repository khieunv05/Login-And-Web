package com.vti.LoginAndWeb.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ScoreDto {
    private String subjectName;

    private float score;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
