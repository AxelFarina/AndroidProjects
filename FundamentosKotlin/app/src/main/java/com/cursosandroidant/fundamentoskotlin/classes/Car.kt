package com.cursosandroidant.fundamentoskotlin.classes

open class Car(val description: String)  {
    fun makeSomething(){
        println("Haz algo...")
    }

   open fun description(){
        println("La descripcion del carro es $description")
    }
}