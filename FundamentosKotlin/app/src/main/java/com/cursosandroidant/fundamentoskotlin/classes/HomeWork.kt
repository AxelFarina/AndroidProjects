package com.cursosandroidant.fundamentoskotlin.classes

import com.cursosandroidant.fundamentoskotlin.newTopic

fun main(){

    /*newTopic("Tarea")
    val cars = Cars(1,"BMW","Un BMW de color azul")
    println(cars)
    val car = Car("El carro es un Mercedes Gris")
    println(car.description)
    car.makeSomething()
    val rentCar = RentCar(description = "Toyota Corola blanco")
    rentCar.description()*/

    newTopic("ITLA")

    for(filas in 1..12 step 1){
        for (columnas in 1..12 step 1){
            if (columnas <=12){
                repeat(1){
                    println("$filas x $columnas = ${filas*columnas}")
                }
            }
        }
    }

}