package com.hatmani.securityservice.Service

import com.hatmani.securityservice.Entity.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.stream.Collectors

//ici on va cree UserDetail a partir de User
class CustomUserDetails : User, UserDetails {
    constructor(user: User) : super(user)

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return roles.stream().map { role -> SimpleGrantedAuthority(role.toString()) }
            .collect(Collectors.toList())

    }

    override fun getPassword(): String {
        return super.passWord!!
    }

    override fun getUsername(): String {
        return super.userName!!
    }

    override fun isAccountNonExpired(): Boolean {
        return super.accountNonExpired
    }

    override fun isAccountNonLocked(): Boolean {
        return super.accountNonLocked
    }

    override fun isCredentialsNonExpired(): Boolean {
        return super.credentialsNonExpired
    }

    override fun isEnabled(): Boolean {
        return super.enabled
    }
}