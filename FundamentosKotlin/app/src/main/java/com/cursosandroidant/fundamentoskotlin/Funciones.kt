package com.cursosandroidant.fundamentoskotlin

import kotlin.math.abs

fun main(){
    newTopic("Funciones")
    sayHello()
    val a = 2
    val b = 3
    println("a + b = ${suma(a,b)}")
    println("a - b = ${sub(a,b)}")
    newTopic("Infix")
    val c = -3
    println(c.enableAbs(false))
    println("$a + $c = ${suma(a,c.enableAbs(true))}")
    println("$a + $c = ${suma(a,c.enableAbs(false))}")

    newTopic("SobreCarga")
    showProduct("Soda","10%")
    showProduct("Panecillos")
    showProduct(name = "Aceite Crisol",validity = "15 de marzo")
}

fun sayHello() {
    println("Hello")
}

fun suma(a:Int, b:Int) = a + b

fun sub(a:Int, b:Int) = a- b

infix fun Int.enableAbs(enable:Boolean) = if (enable) abs(this) else this

fun showProduct(name:String, promo:String = "Sin promocion", validity:String = "Agotar existencia"){
    println("$name = $promo hasta $validity")
}

