package com.hatmani.securityservice.v2.payload.dto

class JwtResponse(
    var token:String="",
    var type:String="Bearer",
    var id:Int,
    var username:String="",
    var roles:List<String>
) {
}