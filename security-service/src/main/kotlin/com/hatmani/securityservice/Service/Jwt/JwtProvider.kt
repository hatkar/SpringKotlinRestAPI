package com.hatmani.securityservice.Service.Jwt

import com.hatmani.securityservice.Service.CustomUserDetails
import io.jsonwebtoken.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtProvider {
    //il faut ajouter \ et lateinit
    @Value("\${app.jwtSecret}")
    private lateinit var jwtSecret:String
    @Value("\${app.jwtExpirationInMs}")
    private var jwtExpirationInMs:Int = 10000

    fun generateToken(authentication: Authentication):String
    {
        var userPrincipal:CustomUserDetails= authentication.principal as CustomUserDetails
        var now :Date= Date()
        var expir:Date = Date(now.time+jwtExpirationInMs)

        return Jwts.builder()
            .setSubject(userPrincipal.userName)
            .setIssuedAt(Date())
            .setExpiration(expir)
            .signWith(SignatureAlgorithm.HS384,jwtSecret)
            .compact()


    }
    public fun getUsernameFromJWT(token:String):String
    {
        return Jwts.parser()
            .setSigningKey(jwtSecret)
            .parseClaimsJws(token)
            .body
            .subject
    }
    public fun validateToken(authToken:String):Boolean
    {
        try {
            Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(authToken)
            return true
        }catch (ex:SignatureException){
        }catch (ex:MalformedJwtException){
        }catch (ex:ExpiredJwtException){
        }catch (ex:UnsupportedJwtException){
        }catch (ex:IllegalArgumentException){
        }
        return false
    }

}