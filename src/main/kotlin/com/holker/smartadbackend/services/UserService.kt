package com.holker.smartadbackend.services

import com.holker.smartadbackend.dto.SmartUser
import com.holker.smartadbackend.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    fun loadAllUsers(): List<SmartUser> {
        val users = userRepository.findAll()
        return users.toList()
    }

    fun saveUser(smartUser: SmartUser) {
        userRepository.save(smartUser)
    }
}