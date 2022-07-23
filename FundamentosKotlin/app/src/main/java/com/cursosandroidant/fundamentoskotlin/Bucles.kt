package com.cursosandroidant.fundamentoskotlin

fun main(){
    newTopic("Bucles")
    showPersons("Fallen","Hamlet","Amelia")
    showPersons("Fallen","Hamlet","Juan","Pedro","Villa")
    homeWork(4)
}

fun showPersons(p1:String, p2:String, p3:String){
    println(p1)
    println(p2)
    println(p3)
}

fun showPersons(vararg persons :String) {
    newTopic("For")

    for (person in persons) println(person)
    newTopic("While")
    var index = 0
    while (index < persons.size) {
        if (persons[index] == "Pedro") {
            println("Es un mmg")
        } else if (index > persons.size) {
            index = 0
        }
        println(persons[index])
        index++
    }


    newTopic("When")
    index = (0..persons.size - 1).random()
    println(index)
    when (persons[index]) {
        "Fallen" -> println("Es Fallen")
        "Hamlet" -> println("El 9 hermano mio")
        "Juan" -> println("Un rpsmd")
        "Pedro" -> println("El idiota")
        "Villa" -> println("El que se fue villa perdio su que???")

        else -> println(persons[index])
    }

}
fun homeWork(numero:Int){
    newTopic("HomeWork")
    println("He traido $numero panes")
    println("Hoy vamos a comer $numero sushis ")
}



