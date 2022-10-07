package com.hatmani.securityservice.Repository

import com.hatmani.securityservice.Entity.Role
import com.hatmani.securityservice.Entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleRepository:JpaRepository<Role,Long> {
    fun findByRolename(rolename: String): Role
}