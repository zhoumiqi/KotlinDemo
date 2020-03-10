package com.demo.kotlin

import android.view.LayoutInflater
import android.widget.Button
import androidx.constraintlayout.solver.widgets.Rectangle
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import java.util.*

/**
 * reference
 * https://kotlinlang.org/docs/reference/basic-syntax.html#using-string-templates
 */
object BasicSyntax {
    private val array = intArrayOf(1, 2, 3, 4)
    private val user: User = User(ObservableField("Lucy"), ObservableField("12345"))
    @JvmStatic
    fun main(args: Array<String>) {
        val items = listOf("hello", "word")
        for (item in items) {
            println("forEach loop for iterator:$item")
        }
        for (index in items.indices) {
            println("for loop indices:index =$index,value =  ${items[index]}")
        }
        var index = 0
        while (index < items.size) {
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
        val fourAngle = FourAngle(2.3, 3.4, 4.5)
        fourAngle.calculate()
        println(fourAngle.perimeter)
        fourAngle.onClick()
        testLet()
        testAlso()
        testWith()
        testRun()
        testApply()
    }

    /**
     * apply函数和run函数很像，唯一不同点就是它们各自返回的值不一样，
     * apply函数的返回的是传入对象的本身,run函数是以闭包形式返回最后一行代码的值
     * 1、apply一般用于一个对象实例初始化的时候，需要对对象中的属性进行赋值。
     * 2、动态inflate出一个XML的View的时候需要给View绑定数据也会用到
     */
    private fun testApply() {
        val resource = MyApplication.getInstance().resources
//        resource.obtainTypedArray(123).apply {
//            this.getColor(R.color.colorPrimary, Color.RED)
//            this.getDimension(R.dimen.activity_horizontal_margin,12)
//            recycle()
//        }
        val view = LayoutInflater.from(MyApplication.getInstance())
            .inflate(R.layout.activity_login, null)
            .apply {
                findViewById<Button>(R.id.btn_login).text = "登录"
            }
    }

    /**
     * run函数是let,with两个函数结合体，准确来说它弥补了let函数在函数体内必须使用it参数替代对象，
     * 在run函数中可以像with函数一样可以省略，直接访问实例的公有属性和方法，另一方面它弥补了with函数传入对象判空问题，
     * 在run函数中可以像let函数一样做判空处理.run函数接收一个lambda函数为参数，以闭包形式返回，返回值为最后一行的值或者指定的return的表达式
     */
    private fun testRun() {
        val result = array.run {
            val lastLine = forEach {
                println(it)
            }
            println("lastLine = $lastLine")
            "this is last line as returned value"
        }
        println("result = $result")
    }

    /**
     * 不是以扩展的形式存在的,而是将某对象作为函数的参数，在函数块内可以通过 this 或省略指代该对象。
     * 返回值为函数块的最后一行或指定return表达式
     * 适用于调用同一个类的多个方法时，可以省去类名重复，直接调用类的方法即可
     */
    private fun testWith() {
        val result = with(user, {
            this.userName.set("Rose")
            password.set("9876")
            printMsg()
            "userName = ${this.userName.get()},password = ${this.password.get()}"
        })
        println("result = $result")
        //由于with函数最后一个参数是一个函数，可以把函数提到圆括号的外部
        val userInfo = with(user) {
            userInfo.set("hello world")
            printMsg()//如果这个方法最后返回 则返回 Kotlin.Unit
            userInfo.get()
        }
        println("temp = $userInfo")
    }

    /**
     * also函数返回的则是传入对象的本身,一般可用于多个扩展函数链式调用
     */
    private fun testAlso() {
        val temp = user.also {
            it.age = ObservableInt(33)
        }.also { it.userInfo = ObservableField("${it.userName.get()}'s age is ${it.age.get()}") }
        println("userInfo = ${temp.userInfo.get()} and password is ${temp.password.get()}")
    }

    /**
     * 在函数块内可以通过 it 指代该对象
     * 返回值为函数块的最后一行或指定return表达式
     * 函数体内使用it替代object对象去访问其公有的属性和方法
     */
    private fun testLet() {
        //扩展函数let的使用
        val result = array.let { arr ->
            arr.forEach {
                println(it)
            }
            arr.size
        }
        println("result = $result")

        val loginResponse = LoginResponse("hello")
        val testResponse = loginResponse.let {
            it.setCode(11)
            it.getCode()
        }
        println("testResponse = $testResponse")
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
    fun whenExpression(obj: Any): String {
        return when (obj) {
            1 -> "this is a bug"
            "2" -> "wrong"
            !is String -> "argument type is not String"
            else -> "default"
        }
    }

    //Ranges

    private fun rangesTest() {
        val a = 3
        val size = 10
        if (a in 1..size + 1) {
            println("$a is in range 1 to ${size + 1}")
        }
        val list = listOf("java", "kotlin", "flutter", "AI", "float")
        if (-1 !in list.indices) {
            if (-1 !in 0..list.lastIndex)
                println("-1 is not in list index")
        }
        if (list.size !in list.indices) {
            println("list size is not in list index too")
        }
        //0..5 = [0,5]
        for (x in 0..5) {
            println(x)
        }
        for (x in 1..10 step 2) {
            println(x)
        }

        for (x in 27 downTo 1 step 3) {
            println(x)
        }
        //Checking if a collection contains an object using in operator:
        when {
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