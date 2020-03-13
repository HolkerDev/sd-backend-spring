package com.holker.smartadbackend.repository

import com.holker.smartadbackend.dto.SmartUser
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : CrudRepository<SmartUser, Long> {
    override fun findById(id: Long): Optional<SmartUser>
    override fun findAll(): MutableIterable<SmartUser>
}