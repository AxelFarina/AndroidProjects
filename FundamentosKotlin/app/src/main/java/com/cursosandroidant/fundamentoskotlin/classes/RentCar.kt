package com.cursosandroidant.fundamentoskotlin.classes

class RentCar(description:String): Car(description) {

    override fun description() {
        println("Esta es la descripcion: $description")
        super.description()
    }
}