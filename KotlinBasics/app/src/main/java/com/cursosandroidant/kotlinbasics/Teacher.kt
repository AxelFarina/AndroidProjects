package com.cursosandroidant.kotlinbasics

class Teacher(firstName:String, lastName:String, var students:Short): Person(firstName,lastName), Boss{
    var clasroom: Classroom = Classroom(("N/A"))
    override fun showWork(): String {
        return super.showWork() + "\nDando clases..."
    }

    override fun namePerson(): String = getFullname()

    override fun netSalary(): Float = salary


    inner class Classroom(var key:String){
        override fun toString(): String {
            return "Classroom: $key"
        }

       fun getInfo():String = "Classroom $key with Teacher $firstName and $students students"
    }
}