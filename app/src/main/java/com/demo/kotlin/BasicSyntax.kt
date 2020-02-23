package com.demo.kotlin

import androidx.constraintlayout.solver.widgets.Rectangle
import java.util.*

/**
 * reference
 * https://kotlinlang.org/docs/reference/basic-syntax.html#using-string-templates
 */
object BasicSyntax {
    @JvmStatic
    fun main(args: Array<String>) {
        val items = listOf("hello", "word")
        for (item in items) {
            println("forEach loop for iterator:$item")
        }
        for (index in items.indices) {
            println("for loop indices:index =$index,value =  ${items[index]}")
        }
        var index=0
        while (index < items.size){
            println("while loop :index =$index,value =  ${items[index]}")
            index++
        }

        println("param args = $args")
        println(plus(20, 15))
        println(add(12, 34))
        defineVariables()
        rangesTest()
        //Create a object
        var rec = Rectangle()

        val rectangle = Rectangle(5.0, 2.0)
        val triangle = Triangle(3.0, 4.0, 5.0)
        println("Area of rectangle is ${rectangle.calculateArea()}, its perimeter is ${rectangle.perimeter}")
        println("Area of triangle is ${triangle.calculateArea()}, its perimeter is ${triangle.perimeter}")
    }

    private fun add(a: Int, b: Int): Int {
        return a + b
    }

    fun plus(a: Int, b: Int) = a - b

    //return type Unit can be omitted(省略)
    fun printSum(prefix: String, suffix: String): Unit {
        println("just test : $prefix,#$suffix")
    }

    /**
     *
     *  this is outer comment
     * /**this is inner comment**/
     * Block comments in Kotlin can be nested.
     *
     */
    private fun defineVariables() {
        //Read-only local variables are defined using the keyword val. They can be assigned a value only once.
        val a: Int = 1
        val b = 2
        val c: Float
        c = 3.2f

        //Variables that can be reassigned use the var keyword:
        var d = 3
        d += 1
        println("d = $d")
    }

    fun StringTemplate() {
        val a = 1
        val str = "this is a key word"
        val target = "a = $a,${str.replace("is", "was")},but now is changed"
        println(target)
    }

    fun maxOf(a: Int, b: Int): Int {
        return if (a > b) a else b
//        return if (a>b){
//            a
//        }else{
//            b
//        }
    }

    fun minOf(a: Int, b: Int) = if (a < b) a else b

    //null  safety
    fun parseInt(str: String): Int? {
        return str.toIntOrNull()
    }

    /**
     * The is operator checks if an expression is an instance of a type.
     * If an immutable local variable or property is checked for a specific type,
     * there's no need to cast it explicitly:
     */
    fun getStringLength(obj: Any): Int? {
        if (obj !is String) return null
        return obj.length
//        if (obj is String) {
//            return obj.length
//        }
//        return null

    }

    //when expression
    fun whenExpression(obj:Any):String{
        return when(obj){
            1 -> "this is a bug"
            "2" -> "wrong"
            !is String -> "argument type is not String"
            else -> "default"
        }
    }

    //Ranges

    private fun rangesTest(){
        val a = 3
        val size = 10
        if(a in 1..size+1){
            println("$a is in range 1 to ${size+1}")
        }
        val list = listOf("java","kotlin","flutter","AI","float")
        if (-1 !in list.indices){
            if (-1 !in 0..list.lastIndex)
            println("-1 is not in list index")
        }
        if (list.size !in list.indices){
            println("list size is not in list index too")
        }
        //0..5 = [0,5]
        for (x in 0..5){
            println(x)
        }
        for (x in 1..10 step 2){
            println(x)
        }

        for (x in 27 downTo 1 step 3){
            println(x)
        }
        //Checking if a collection contains an object using in operator:
        when{
            "java" in list -> println("java is in the list")
            "python" !in list -> println("python is not in the list")
        }
        //Using lambda expressions to filter and map collections:
        list.filter { it.startsWith("f") }
            .sortedBy { it }
            .map { it.toUpperCase(Locale.getDefault()) }
            .forEach { println(it) }
    }

    abstract class Shape(val sides: List<Double>) {
        val perimeter: Double get() = sides.sum()
        abstract fun calculateArea(): Double
    }

    interface RectangleProperties {
        val isSquare: Boolean
    }

    class Rectangle(
        var height: Double,
        var length: Double
    ) : Shape(listOf(height, length, height, length)), RectangleProperties {
        override val isSquare: Boolean get() = length == height
        override fun calculateArea(): Double = height * length
    }

    class Triangle(
        var sideA: Double,
        var sideB: Double,
        var sideC: Double
    ) : Shape(listOf(sideA, sideB, sideC)) {
        override fun calculateArea(): Double {
            val s = perimeter / 2
            return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC))
        }
    }

}