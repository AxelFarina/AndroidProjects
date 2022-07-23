package com.cursosandroidant.kotlinbasics

import android.graphics.ColorSpace

fun main(){
    newTopic("POO")
    subTopic("class")
    println(School())

    //constructor
    subTopic("Constructor")
    val school = School("Harv","Calle Principal #14")
    println(school)

    //override
    subTopic("override")
    val schoolInactive = School("Harv","Calle Principal #14",School.INACTIVE)
    println(schoolInactive)

    //this
    subTopic("This")
    val highSchool = School("Stan","Independence #232", mutableListOf(Person("Jose","Rodriguez")))
    println(highSchool)

    //properties & methods
    subTopic("Propiedades y metodos")
    val person = Person("Axel","Farina")
    println(person.getFullname())
    println(person.showWork())
    person.salary = 10000f
    println(person.salary)

    //Set & Get
    subTopic("Set y Get")
    person.tax = 20f
    println(person.salary)

    //Herencia
    subTopic("Herencia")
    val teacher = Teacher("Alex","Castillo", 45)
    highSchool.staff.add(teacher)
    val admin = Admin("Gerardo","Torres",1)
    highSchool.staff.add(admin)
    println(highSchool)
    //super
    subTopic("Super")
    println(teacher.showWork())
    println(admin.showWork())

    //Visibilidad  o encapsulacion
    subTopic("Encapsulacion")
    println(teacher.firstName)
    //println(teacher.lastName)

    //companion object
    subTopic("Companion Object")
    println(School.ACTIVE)
    val schoolActive = School("Oxf","Calle Roma #421", School.ACTIVE)
    println(schoolActive)

    //Enum
    subTopic("Enum")
    schoolActive.setType(TypeSchool.PRIVATE)
    println(schoolActive.getType())

    //Nested Class
    subTopic("Clase anidada")
    println(teacher.clasroom)
    teacher.clasroom.key = "4toA"
    println(teacher.clasroom)

    //inner
    subTopic("Inner")
    println(teacher.clasroom.getInfo())

    //interface
    subTopic("interface")
    val boss:Boss = teacher
    teacher.salary = 10000f
    println(boss.namePerson())
    println(boss.netSalary())

    //data class
    subTopic("Data class")
    println(schoolActive)
    println(schoolActive.component1())
    val schoolCopy = schoolActive.copy()
    println(schoolCopy)
    schoolCopy.name = "ford"
    println(schoolCopy)

    //equal & hashcode
    subTopic("equal & hashcode")
    schoolActive.numCode = "356"
    schoolCopy.numCode = "357"
    println(schoolActive.equals(schoolCopy))

    //Tarea
    subTopic("Tarea Heredar")
    val autos = Autos("Mercedes","2014")
    println("Este es el automovil: ${autos.getFullAutos()}")
    val modelos = Modelos("Mercedes-Benz", "Gris Oscuro","Maybach")
    println("El carro es un: ${autos.getFullAutos()} ${modelos.showCars()}")
}