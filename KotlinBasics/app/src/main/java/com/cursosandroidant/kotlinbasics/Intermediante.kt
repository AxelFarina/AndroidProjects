package com.cursosandroidant.kotlinbasics


fun main(){
    newTopic("Sentencias condicionales")

    subTopic("If")
    if (false) {
        println("MMGBO")
    }

    //equality
    subTopic("Equality")
    if(1 == 1){
        println("1 es igual a 1")
    }
    //equals
    subTopic("Equals")
    val ax = "Axel"
    if(ax.equals("Axe")){
        println("Es lo mismo")
    }else{
        println("No es el mismo nombre")
    }

    //Operadores logicos
    subTopic("Operadores logicos")
    if(1 != 2){ //not
        println("1 Es diferente a 2")
    }

    if(1 == 1 || 1 < 2){
        println("1 Es igual o menor a 2")
    }

    if(1 != 2 && 1 < 2){
        println("1 Es diferente y menor que 2")
    }

    if(1 == 1){
        if(1 < 2){
            println("If anidado")
        }
    }

    //If else
    subTopic("If else")
    val a = 5
    val b = 5
    if(a > b){
        println("a es mayor que b")
    }else{
        println("a no es mayor que b")
    }

    if(a < b){
        println("a es menor que b")
    }else if (a == b){
        println("a es igual que b")
    }else{
        println("a es mayor a b")
    }

    //When
    subTopic("When")
    val name = "Cursos Android ANT"

    if(name.equals("Karina")){
        println("Hola karina")
    }else if(name.equals("Pablo")){
        println("Hola Pablo")
    }else if(name.equals("Axel") || name.equals("Cursos Android ANT")){
        println("Hola ADMIN")
    }else{
        println("Hola desconocido")
    }

    when(name){
        "Karina" -> println("Hola karina")
        "Pablo" -> println("Hola Pablo")
        "Axel", "Cursos Android ANT" -> println("Hola ADMIN")
        else -> println("Hola desconocido")
    }

    //Estructura de datos
    newTopic("Collections")
    //vararg
    subTopic("Vararg")
    multiArguments("Karina","Pamela","Pablo")

    //Arrays             0   1   2   3   4   5
    val array = arrayOf('p','a','m','e','l','a')
    println(array[0])
    println(array[1])
    println(array[2])
    println(array[3])
    println(array[4])
    println(array[5])
    val arrayStr = "Pamela"
    println(arrayStr[4])

    //ListOf
    subTopic("ListOf")
    //val readOnlyList = listOf<String>("Axel","Mina","Ramon")
    val readOnlyList: List<String>
    readOnlyList = listOf("Axel","Mina","Ramon")
    println("Read-only $readOnlyList")
    println("Name at 1 = ${readOnlyList[0]}")

    //mutableListOf
    subTopic("mutableList")
    val mutableList = mutableListOf("Axel","Mina","Ramon")
    println("Mutable: $mutableList")
    mutableList.add("Juan")
    println("Add: $mutableList")
    mutableList.removeAt(1)
    println("RemoveAt: $mutableList")
    mutableList.remove("Juan")
    println("Remove: $mutableList")
    mutableList.set(1,"Angel")
    println("set: $mutableList")

    //map
    subTopic("map")
    val mutableMap = mutableMapOf<String, String>()
    mutableMap.put("Ax","Axel")
    mutableMap.put("Pa","Pamela")
    mutableMap.put("Chris","Christian")
    println("Map: $mutableMap")
    println("Get by key: ${mutableMap["Ax"]}")
    mutableMap.remove("Pa")
    mutableMap.set("Ax","Alejandro")
    println("remove and set: $mutableMap")
    println(mutableMap.keys)
    println(mutableMap.values)

    //ArrayOfNull
    subTopic("Array Of Null")
    val nullArray = arrayOfNulls<String>(3)
    nullArray[1] = "Karina"
    println(nullArray[1])
    println(nullArray[0])

    //Methods collections
    subTopic("Metodos en colecciones")
    println(readOnlyList)
    println("sort: ${readOnlyList.sorted()}")
    println("reverse: ${readOnlyList.reversed()}")
    println("indefOf Laura: ${readOnlyList.indexOf("Axel")} ")

    //loops
    newTopic("Bucles")
    loops("Karina", "Pamela", "Pablo", "Juan", "Albert")

}

fun loops(vararg names:String) {
    //for
    subTopic("for")
    for (i in 0..100 step 5) {
        println(i)
    }

    for (i in 0..names.size - 1) {
        println("$i = ${names[i]}")
    }

    for (name in names) {
        println(name)
    }

    //forEach
    subTopic("forEach")
    names.forEach { name ->
        println(name)
    }

    (1..5).forEach {
        println(it)
    }

    //While
    subTopic("While")
    var index = 0
    println(names.size)
    while (index < names.size) {
        println("\nindex: $index\n name at index: ${names.get(index)}")
        //index = index + 1
        index++
    }

    //Do While
    subTopic("Do While")
    do {
        index--
        println("\nindex: $index\n name at index: ${names.get(index)}")
    } while (index > 0)

    //Return
    subTopic("Return")
    (1..5).forEach {
        if (it == 3) {
            return@forEach
        }
        println(it)
    }

    //break
    subTopic("Break")
    for (i in 1..10) {
        if (i == 3) {
            break
        }
        println(i)
    }

    index = names.size
    do {
        index--
        if (index < 0) {
            break
        }
        println("\nindex: $index\n name at index: ${names.get(index)}")
    } while (index >= 0)

    //Tarea
    newTopic("Tarea")
    val hwMutableList = mutableListOf("Axel","Mina","Ramon","Alain")
    hwMutableList.forEach{
        val saludos = when(it){
            "Axel" -> "Hola Axel"
            "Mina" -> "Hola Mina"
            "Ramon" -> "Hola ramon"
            "Alain" -> "Hola Alain"
            else -> "Hola $it"
        }
        println(saludos)

    }
}

fun multiArguments(vararg name:String){
    println("vararg en la posicion 0: ${name[0]}")
}