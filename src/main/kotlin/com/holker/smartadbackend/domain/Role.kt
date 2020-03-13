package com.holker.smartadbackend.domain

import javax.persistence.*

@Entity
@Table(name = "roles")
class Role(val name: String) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0
}