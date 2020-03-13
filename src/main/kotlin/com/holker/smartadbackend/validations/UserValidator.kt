package com.holker.smartadbackend.validations

import com.holker.smartadbackend.dto.SmartUser
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.Validator

@Component
class UserValidator : Validator {
    override fun validate(target: Any, errors: Errors) {
        val user = target as SmartUser

        if (user.password.length < 6) {
            errors.rejectValue("password", "Length", "Password " +
                    "must be at least 6 characters")
        }

        if (user.name.length < 2) {
            errors.rejectValue("name", "Empty", "Name is too short")
        }
    }

    override fun supports(clazz: Class<*>): Boolean {
        return SmartUser::class.java == clazz
    }

}