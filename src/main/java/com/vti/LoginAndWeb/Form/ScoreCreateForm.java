package com.vti.LoginAndWeb.Form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter

public class ScoreCreateForm {
    @NotBlank
    @Length(max = 200)
    private String name_subject;

    @NotNull
    @Max(value = 10)
    @Min(value = 0)
    private float score;
}
