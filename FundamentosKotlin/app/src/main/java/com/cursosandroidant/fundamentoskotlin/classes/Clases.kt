package com.cursosandroidant.fundamentoskotlin.classes

import com.cursosandroidant.fundamentoskotlin.newTopic

fun main(){
    newTopic("Clases")
    val phone: Phone = Phone(132342)
    phone.call()
    phone.showNumber()
    //println(phone.number)

    newTopic("Herencia")
    val smartPhone = SmartPhone(242424,true)
    smartPhone.call()

    newTopic("Sobreescritura")
    smartPhone.showNumber()
    println("Privado? ${smartPhone.isPrivate}")

    newTopic("Data Classes")
    val myUser = User(0,"Axel","Farina",Group.FAMILY.ordinal)
    val bro = myUser.copy(id = 1, name = "Ivan")
    val friend = bro.copy(id = 2, group = Group.FRIEND.ordinal)
    println(myUser.component3())
    println(myUser)
    println(bro)
    println(friend)

    newTopic("Funciones de alcance")
    with(smartPhone){
        println("Privado $isPrivate")
        call()
    }

    //friend.group = Group.WORK.ordinal
    friend.apply {
        group = Group.WORK.ordinal
        name = "Juan"
        lastname = "Tellez"
    }

    println(friend)
}