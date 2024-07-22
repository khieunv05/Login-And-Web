package com.vti.LoginAndWeb.Form;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserFilterForm {
    private String search;

    private LocalDate minCreatedDate;

    private LocalDate maxCreatedDate;
}
