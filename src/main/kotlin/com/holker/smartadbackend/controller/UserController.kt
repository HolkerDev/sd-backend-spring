package com.holker.smartadbackend.controller

import com.holker.smartadbackend.dto.SmartUser
import com.holker.smartadbackend.services.MapValidationErrorService
import com.holker.smartadbackend.services.UserService
import com.holker.smartadbackend.validations.UserValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/user")
class UserController {
    @Autowired
    lateinit var userService: UserService

    @Autowired
    lateinit var userValidator: UserValidator

    @Autowired
    lateinit var mapValidator: MapValidationErrorService

    @PostMapping("/register")
    fun createUser(@Valid @RequestBody user: SmartUser, result: BindingResult): ResponseEntity<*> {
        userValidator.validate(user, result)
        val errorMap = mapValidator.createErrorMap(result)

        if (errorMap != null) {
            return errorMap
        }


        userService.saveUser(user)

        return ResponseEntity<String>("Created successfully", HttpStatus.CREATED)
    }
}