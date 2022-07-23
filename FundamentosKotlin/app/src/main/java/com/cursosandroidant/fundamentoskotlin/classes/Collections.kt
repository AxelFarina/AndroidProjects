package com.cursosandroidant.fundamentoskotlin.classes

import com.cursosandroidant.fundamentoskotlin.newTopic

fun main(){
    newTopic("Collections")
    newTopic("Read Only")
    val frutaList = listOf("Manzana","Banana","Uva","Lima")
    println(frutaList.get((0..frutaList.size-1).random()))
    println("Index de Uva es ${frutaList.indexOf("Uva")}")


    newTopic("Mutable List")
    val myUser = User(0,"Axel","Farina",Group.FAMILY.ordinal)
    val bro = myUser.copy(id = 1, name = "Ivan")
    val friend = bro.copy(id = 2, group = Group.FRIEND.ordinal)
    val usersList = mutableListOf<User>(myUser,bro)
    println(usersList)
    usersList.add(friend)
    println(usersList)
    //usersList.removeAt(1)
    usersList.remove(bro)
    println(usersList)

    val usersSelectList = mutableListOf<User>()
    println(usersSelectList)
    usersSelectList.addAll(usersList)
    usersSelectList.add(myUser)
    println(usersSelectList)
    usersSelectList.set(0,bro)
    println(usersSelectList)


    newTopic("Map")
    val usersMap = mutableMapOf<Int,User>()
    println(usersMap)
    usersMap.put(myUser.id.toInt(), myUser)
    usersMap.put(myUser.id.toInt(), myUser)
    println(usersMap)

    usersMap.put(friend.id.toInt(), friend)
    println(usersMap)
    usersMap.remove(2)
    println(usersMap.isEmpty())
    println(usersMap.containsKey(0))
    usersMap.put(bro.id.toInt(),bro)
    usersMap.put(friend.id.toInt(), friend)
    println(usersMap)
    println(usersMap.keys)
    println(usersMap.values)



}