package com.cursosandroidant.kotlinbasics

var username = "Ax"
const val SPECIES = "Human"
private const val SEPARATOR = "==================="

fun main(){
 print("Kotlin Basic, DO WHAT I SAY MOTHERFUCKER")
 println()

   //Variables
    newTopic(topic = "Variables")
   var age = 30
   println(age)
   val name = "Axel"
   println(name)

   val job:String = "Developer"
   //job = 30 <- Error
   println(job)

   val language:String
   language = "Kotlin"
   println(language)

    //Variables Globales
    newTopic(topic = "Variables Globales")
    println(username)
    println(SPECIES)

    //String Template
    newTopic(topic = "String Template")
    println("Mi nombre es $name, trabajo como $job en el lenguaje de programacion $language y " +
            "tengo la edad de $age años")

    //Tipos de datos
    newTopic(topic = "Tipos de datos")
    val char:Char = 'a'
    val char2:Char = 'x'
    print(char)
    print(char2)
    println()

    val boolean:Boolean = true //true = 1 false = 0 <- 1 bit
    println(boolean)

    //Tipos de datos numericos
    newTopic(topic = "Tipos de datos numericos")
    val jobs:Byte = 3
    println("$jobs trabajos")

    val WorkedDays:Short = 200
    println("He trabajado $WorkedDays dias")

    val WorkMinutes:Int = 2880000
    println("$WorkMinutes Minutos trabajados")

    val WorkedInMilliseconds:Long = 17280000000
    println("$WorkedInMilliseconds milisegundos trabajados")

    val height:Float = 1.75f
    println("Estatura: ${height}m")

    val heightDouble:Double = 1.733333333333
    println("Estatura real: ${heightDouble}m")

    //Funciones
    newTopic(topic = "Funciones")
    basic()
    arguments(name)
    println(returnData())

    //Sobre Carga
    newTopic(topic = "Sobre Carga")
    overload(age)
    overload(job)
    overload(job, language)
    overload(language = language)

}

fun overload(job: String = "Intern", language:String){
    println("Mi trabajo es: $job con $language ")
}

fun overload(job: String) {
    println("Mi trabajo es: $job")
}

fun overload(age: Int) {
    println("Mi edad es $age")
}

fun returnData(): String {
    return "Datos retornados"
}

fun arguments(name: String) {
    println("Hola $name")
}

fun basic(){
    println("Hi")
}
    //Funciones para los comentarios

fun newTopic(topic:String){
    print("\n $SEPARATOR $topic $SEPARATOR \n")
}
fun subTopic(subTopic: String){
    print("\n$SEPARATOR $subTopic\n")
}

