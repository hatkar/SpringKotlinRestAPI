package com.hatmani.securityservice.Entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.hatmani.securityservice.Enum.RoleName
import javax.persistence.*

@Entity
data class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    @Enumerated(EnumType.STRING)
    var name: RoleName,
    @ManyToMany(mappedBy = "roles")
    @JsonIgnoreProperties("roles")
    var users:MutableList<User> =mutableListOf()
)


