package com.hatmani.securityservice.Entity


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*
@Entity
open class User(
    var firstName: String = "",
    var lastName: String = "",
    var userName: String = "",
    var email: String = "",
    var passWord: String = ""){


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long=0

    var enabled:Boolean =true
    var accountNonExpired: Boolean = true
    var accountNonLocked: Boolean = true
    var credentialsNonExpired: Boolean = true
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name="users_roles",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name="role_id")]
    )

    var roles: MutableList<Role> = mutableListOf()

    constructor(user: User) : this(user.firstName, user.lastName, user.userName, user.email, user.passWord){
        id = user.id
        firstName = user.firstName
        lastName = user.lastName
        userName = user.userName
        email = user.email
        passWord = user.passWord
        accountNonExpired = user.accountNonExpired
        accountNonLocked = user.accountNonLocked
        credentialsNonExpired = user.credentialsNonExpired
        enabled = user.enabled
        roles = user.roles
    }
}