package com.cursosandroidant.kotlinbasics

fun main(){
    //Var
    var age = 30
    age = 25
    val job = "Doctor"
    println("$job de $age años")

    val lenguage:String
    lenguage = "Kotlin"

    fun form(name:String, age:Byte, job:String, height:Float){
        print("Mi nombre es $name y tengo la edad de $age. \nTrabajo en $job y mi altura es de: ${height}m\n")
    }

    form("Axel",17, "Software Developer", 1.73f)
}