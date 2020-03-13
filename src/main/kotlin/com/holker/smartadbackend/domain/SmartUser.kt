package com.holker.smartadbackend.dto

import com.sun.istack.NotNull
import org.springframework.lang.NonNull
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "smart_users")
class SmartUser(
        @NotBlank(message = "Name should be filled")
        val name: String,
        @NotBlank(message = "Password should be filled")
        @Column(name = "password")
        val password: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0
}