package com.cursosandroidant.kotlinbasics

class Modelos(val marca:String, val color:String, val modelo:String): Autos() {

    override fun showCars(): String {
        return super.showCars() + "marca $marca del modelo $modelo color $color"
    }
}