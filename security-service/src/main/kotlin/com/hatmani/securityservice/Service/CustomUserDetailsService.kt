package com.hatmani.securityservice.Service

import com.hatmani.securityservice.Repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
open class CustomUserDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {

        // CustomUserDetails(userRepository.findOneByUserName(username))
        /*  Required: User Found: User? on ajoute !!
         */
        return CustomUserDetails(userRepository.findOneByUserName(username)!!)
    }
}