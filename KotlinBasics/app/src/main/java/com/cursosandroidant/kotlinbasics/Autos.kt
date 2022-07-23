package com.cursosandroidant.kotlinbasics

open class Autos(val car:String, val year:String) {

    constructor() : this("","")

    fun getFullAutos():String = "$car del año $year"

    open fun showCars():String {
        return "\nSus caracteristicas son:"
    }



}