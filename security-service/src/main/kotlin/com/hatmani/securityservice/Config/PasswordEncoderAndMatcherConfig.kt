package com.hatmani.securityservice.Config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
class PasswordEncoderAndMatcherConfig {
@Bean
open fun passwordEncoderAndMatcher():PasswordEncoder{
    return  object :PasswordEncoder{
        override fun encode(p0: CharSequence?): String {
            return BCryptPasswordEncoder().encode(p0)
        }

        override fun matches(p0: CharSequence?, p1: String?): Boolean {
            return BCryptPasswordEncoder().matches(p0, p1)
        }

    }
}


}