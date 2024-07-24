package com.vti.LoginAndWeb.validation;

import com.vti.LoginAndWeb.Repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserIdExistsValidator implements ConstraintValidator<UserIdExists,Long> {
    private final UserRepository userRepository;
    @Override
    public boolean isValid(Long id, ConstraintValidatorContext constraintValidatorContext) {
        return userRepository.existsById(id);
    }
}
