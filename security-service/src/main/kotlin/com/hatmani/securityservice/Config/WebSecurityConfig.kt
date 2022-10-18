package com.hatmani.securityservice.v2.service


import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.ProviderManager
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
    prePostEnabled=true)
class WebSecurityConfig(private val userDetailsService:UserDetailsServiceImpl,
                        private val unauthorizedHandler:AuthEntryPointJwt,
                        private val jwtAuthenticationFilter: AuthTokenFilter,
                        private val accesDenid : CustomAccessDeniedHandler
) {
    @Bean
    fun passwordEncoder(): PasswordEncoder? {
        return BCryptPasswordEncoder()
    }

   @Bean
    @Throws(java.lang.Exception::class)
    fun  authenticationManager(authConfig: AuthenticationConfiguration):AuthenticationManager
    {
        return authConfig.authenticationManager
    }

    /*@Bean
    @Throws(Exception::class)
    fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration?): AuthenticationManager? {
        return ProviderManager(authenticationProvider)
    }*/
/*@Bean
    @Throws(Exception::class)
    fun configure(authenticationManagerBuilder: AuthenticationManagerBuilder): DaoAuthenticationConfigurer<AuthenticationManagerBuilder, UserDetailsServiceImpl>? {
     return  authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder())
    }*/
    @Bean
    @Throws(java.lang.Exception::class)
    protected fun configure(http: HttpSecurity): SecurityFilterChain {

 /*   val authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder::class.java)
    authenticationManagerBuilder.userDetailsService(userDetailsService)
    var authenticationManager = authenticationManagerBuilder.build()

    http.csrf().disable().cors().disable().authorizeHttpRequests()

        .antMatchers("/api/v1/account/register", "/api/v1/account/auth").permitAll()
        .anyRequest().authenticated()
        .and()
        .authenticationManager(authenticationManager)
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    return http.build()



        val authenticationManagerBuilder2 = http.getSharedObject(
            AuthenticationManagerBuilder::class.java
        )
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder())
 authenticationManagerBuilder.build()*/

        http.cors().and().csrf().disable()
            .authorizeRequests().antMatchers("/authapi/**").permitAll()
            .antMatchers("/auth/**").permitAll()
            .antMatchers("/protected/**").authenticated()
            .antMatchers("/h2-console").permitAll()
            .and()

            .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
            .accessDeniedHandler(accesDenid)
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

            .and()


        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java)
    http.getSharedObject(AuthenticationManagerBuilder::class.java)
        .userDetailsService(userDetailsService).passwordEncoder(passwordEncoder())//.authenticationManager(authenticationManager)

        http.headers().frameOptions().disable()

    return http.build()
    }
}