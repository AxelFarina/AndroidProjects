package com.cursosandroidant.kotlinbasics

import java.lang.Exception

private var nullStrGlobal:String? = null

private lateinit var lateinitGlobal: String
private val lazyGlobal: Any by lazy { "gLazyKotlin" }

fun main(){
    newTopic("Metodos Strings")
    val course = "Kotlin course by Cursos Android ANT"
    val target = "Android"
    println(course.length)
    println(course.compareTo(target))
    println(course.equals(target))
    println(course.contains(target))
    println(course.lowercase())
    println(course.uppercase())
    println(course.subSequence(0,6))
    println(course.indexOf("N"))
    val empty = " "
    println(empty.isBlank())
    println(empty.isEmpty())
    println(course.lastIndexOf("n"))
    println(course.lowercase().lastIndexOf("n"))
    println(course.replace('c','k'))
    println(course.lowercase().replace("an","os"))
    println(course.replaceBefore("by","Only "))
    println(course.reversed())
    println(course.slice(20..course.length-1))
    println(course.split(" "))
    println(course.startsWith('K'))
    println(course.substring(14,16))
    println(course.substring(course.lastIndexOf('A',course.length)))
    println(" Android Kotlin ".trim())

    //Nullable ? !!
    newTopic("Null safety")
    subTopic("?")
    var nullStr:String? = null
    println(nullStr)
    nullStr = "hello"
    println(nullStr.get(0))
    println(nullStrGlobal?.reversed())
    subTopic("!!")
    nullStr = null
    showMessage(nullStr)
    nullStrGlobal = null//"Android"
    showMessage("kotlin")

    //elvis operator ?:
    subTopic("Operador Elvis")
    nullStrGlobal = "Kotlin"
    val elvis = nullStrGlobal ?: "Java"
    println("Yo programo en $elvis")

    val noElvis = if(nullStrGlobal != null){
        nullStrGlobal
    }else{
        "Java"
    }
    println("Yo programo en $noElvis")

    //ReadLine
    subTopic("ReadLine")
    println("Inserte un numero:")
    val first = readLine()
    val a = first!!.toInt()
    println("a = $a")

    println("Inserte otro numero:")
    val second = readLine()
    val b = second!!.toInt()
    println("b = $b")

    //Operadores Matematicos
    newTopic("Operadores Matematicos")
    println("a + b = ${a+b}")
    println("a - b = ${a-b}")
    println("a * b = ${a*b}")
    println("a / b = ${a/b}")
    println("a % b = ${a%b}")

    //Cast
    newTopic("Safe Cast")
    subTopic("Smart cast")
    var obj: Any = 5//"Kotlin course"
    //println(obj.toString().toInt()*b)
    val objNum:Any = 3//"3"
    if(objNum is Int){
        println("objNum es un numero")
        println(objNum.toString().toInt()*b)
    }else{
        println("objNum no es un numero")
    }

    //try catch finally
    subTopic("Try catch finally")
    try {
        println(obj.toString().toInt()*b)
        println("obj es un numero y esta es la ultima linea del try")
    }catch(e:Exception){
        println(e)
        println("Mensaje personalizado para el error en catch")
    }finally {
        println("Try catch finalizado...")
    }

    //unsafe cast & safe cast
    subTopic("Unsafe cast")
    obj = true
    //val unsafeStr:String = obj as String
    //println(unsafeStr)
    subTopic("Safe cast")
    obj = true
    //val safeStr = obj as? String
    //println(safeStr)

    //throw
    subTopic("throw")
    val job = "Designer"
    try {
        checkType(b)
    } catch (e: Exception) {
        println(e)
    } finally {
        println("Tarea finalizada correctamente")
    }

    //infix(extension)
    subTopic("Infix")
    val name = "Android"
    println(name.uppercase())
    println(name.lowercase())
    println(name.toMixCase(true))
    println(name.toMixCase(false))

    //Lazy & lateinit
    newTopic("Asignacion tardia")
    subTopic("lateinit")
    if(setValueForLateinit()){
        println(lateinitGlobal)
        println(lateinitGlobal.toMixCase(true))
    }

    subTopic("lazy")
    println(lazyGlobal)

    //Scope functions
    newTopic("Funciones de alcance")
    val highSchool = School("Stan","Independence #232", mutableListOf(Person("Jose","Rodriguez")))
    val teacher = Teacher("Alex","Castillo", 45)
    val admin = Admin("Gerardo","Torres",1)

    //With
    subTopic("With") //CON este objeto haz algo...
    with(highSchool){
        println("Con este objeto imprime lo siguiente")
        println(getType())
        println(toString())

    }

    //Apply
    subTopic("apply") //APLICA las siguientes configuraciones...
    teacher.apply {
        clasroom.key = "4tob"
        salary = 2000f
    }
    println("Valores asignados correctamente con apply")
    println(teacher.clasroom.key)
    println(teacher.salary)

    //run
    subTopic("run") //CORRE(ejecuta) el siguiente bloque...
    highSchool.run {
        println("Ejecuta el siguiente bloque de codigo en el objeto")
        staff.add(teacher)
        staff.add(admin)
        println("Members:${staff.size}")
        println(this)
    }

    //let
    subTopic("let") //PERMITE(deja) ejecutar un bloque de codigo a un objeto no null(verificado con ?)...
    var school:School? = null
    school = createSchool()
    school?.let{
        school.staff.add(admin)
        println("Si el objeto es diferente de null, permite imprimirlo: $it")
    }

    //also
    subTopic("also") //Y ADEMAS.... ejecuta el siguiente codigo...
    val udemy: School
    udemy = School().apply {
        numCode = "458".also {
            println("y tambien, notifica que el codigo de la escuela nueva es: $it")
        }
    }

}
private fun createSchool(): School? = School("Harv","Calle Principal #14")

private fun setValueForLateinit():Boolean{
    lateinitGlobal = "gLateinitKotlin"
    return lateinitGlobal.isNotEmpty()
}

private infix fun String.toMixCase(firstUpper: Boolean): String{
    var mixString = ""
    var index = 0
    var module = 0

    if(firstUpper){
        this.uppercase()
    }else{
        this.lowercase()
        module = 1
    }
    while (index < this.length){
        if(index % 2 == module){
            mixString += this.get(index).uppercase()
        }else{
            mixString += this.get(index).lowercase()
        }
        index++
    }

    return mixString
}

private fun checkType(value:Any) {

        if (value is String) {
            println("String valido")
        }else{
            throw TypeCastException("No es un String")
        }
    }


private fun showMessage(msg:String?){
    println("? ${msg?.get(0)}")

    if(msg != null){
        println("! ${msg.get(0)}")
    }

    if(nullStrGlobal != null){
        println("g!! ${nullStrGlobal!!.get(0)}")
    }
}