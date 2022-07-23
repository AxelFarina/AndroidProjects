package com.cursosandroidant.fundamentoskotlin

fun main (){
  newTopic("Variables y constantes")
    val a = 2
    println("a = $a")

    var b:Any = 2
    b = "Hola"
    println("b = $b")

    var objNull: String?
    objNull = null
    println(objNull)


}

fun newTopic(topic:String){
    /*print("======== ")
    print(topic)
    print(" ========")
    println()*/
    print("\n======== $topic ========\n")
}