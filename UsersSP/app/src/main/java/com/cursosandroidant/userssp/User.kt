package com.cursosandroidant.userssp

data class User(val id: Long, val name:String,  var lastName: String, var url:String){
    fun getFullName(): String = "$name $lastName"
}
