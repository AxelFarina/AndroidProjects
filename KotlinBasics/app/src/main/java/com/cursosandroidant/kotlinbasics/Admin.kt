package com.cursosandroidant.kotlinbasics

class Admin(firstName:String, lastName:String, var officeNumber:Short): Person(firstName,lastName) {
    override fun showWork(): String {
        return "Agendando...\n${super.showWork()+ " en la oficina $officeNumber"} "
    }
}