package com.example.praktikum1.util;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator; // PERBAIKAN: Gunakan jakarta.validation
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@AllArgsConstructor
public class ValidationUtil {

    @Autowired
    private Validator validator;

    public void validate(Object request) {
        // Sekarang method validate(Object) akan tersedia
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(request);
        if (!constraintViolations.isEmpty()) { // Menggunakan !isEmpty() lebih rapi
            throw new ConstraintViolationException(constraintViolations);
        }
    }
}