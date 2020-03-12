package com.demo.kotlin

/**
 * 构造方法演示
 * 1、主构造方法(primary constructor),跟在类名后面,没有方法体,只能有一个主构造方法
 * 主构造方法中的属性默认是public的，所以可以用private 修饰，这样属性可以不被直接访问
 *
 * 2、次(从)构造方法(secondary constructor) 必须直接或间接调用主构造方法
 *【this是调用自己的，super是调用父类的】
 */
class ConstructorModel constructor(val name: String = "Lucy") {
    constructor(name: String, age: Int, gender: Int, address: String) : this(name) {}

    private lateinit var familyName: String
    /**
     * 1、你想重写哪个属性的set，get方法，就在哪个属性下方写set，get方法，
     * 2、不用成对出现，可以只重写set方法，也可以只重写get方法
     * 3、用field表示你想要的值
     */
    var age: Int = 0
        set(value) {
            field = value + 100
        }
        get() {
            return field + 1
        }
    var gender: Int = 1
        set(value) {
            field = value % 2
        }
        get() {
            return if (field % 2 == 0) 1 else 2
        }

    var address: String = "China"

    /**'
     * 初始化数据会在构造方法(无论是主还是次构造方法)之前执行
     */
    init {
        println("init : this will be invoked before constructor")
    }

    /**
     * 多个初始化方法会顺序执行，且都在构造方法(无论是主还是次构造方法)之前执行
     */
    init {
        println("init : this will be invoked before constructor after first init")
    }

    /**
     * 次构造方法，可以多个
     */
    constructor(name: String, age: Int) : this(name) {
        println("constructor :  name = $name,age = $age")
        this.age = age
    }

    /**
     * 次构造方法，可以多个
     * this 关键字表示会调用自己的其他构造方法
     */
    constructor(name: String, age: Int, gender: Int) : this(name, age) {
        this.age = age
        this.gender = gender
    }

    /**
     * 主构造函数
     * open可以使得内部类可以被继承
     */
    open inner class InnerClass constructor(name: String) {

    }

    /**
     * 主构造方法没有任何注解或者可见性修饰符时，可以省略，写成下面这样
     */
    inner class InnerClass2 : ConstructorModel.InnerClass {
        /**
         * super关键字用于表示调用父类的构造方法
         */
        constructor(name: String, age: Int) : super(name) {

        }
    }

    /**
     * 这种就是有注解标记的主构造方法，不能省略
     */

    inner class InnerClass3 internal constructor() {

    }


    inner class InnerClass4 {
        constructor() {
            val innerClass = InnerClass("")
        }

        constructor(name: String) {

        }


    }

    inner class InnerClass5(userName: String, password: String) {
        private val userName: String
        private val password: String

        init {
            this.userName = userName
            this.password = password
        }

    }

    /**
     * 当constructor关键字没有注解和可见性修饰符作用于它时，constructor关键字可以省略
     */
    inner class InnerClass6(private val userName: String, private val password: String) {

    }

    /**
     * 如果类不包含其他操作函数，花括号也可以省略
     * 在JVM上，如果类的primary构造方法的所有参数都拥有默认值，
     * 那么Kotlin编译器就会为这个类生成一个不带参数的构造方法。
     * 这个不带参数的构造方法会使用这些参数的默认值，
     * 这样做的目的在于可以跟Spring等框架更好地集成。
     */
    inner class InnerClass7(val userName: String = "Jack", password: String = "1234")

    /**
     * 用var修饰，默认给成员增加了默认值
     * 成员如果没有var/val修饰或者被private修饰，则类的外部无法访问该属性
     */
    inner class InnerClass8(var userName: String = "Rose") {
        fun accessProperty() {
            //userName如果没有var或者val修饰则无法访问
            println(userName)
        }
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println("this is test main method in companion object")
            val innerClass8 = ConstructorModel().InnerClass8();
            println("inner8=${innerClass8.userName}}")
        }
    }

}

fun main() {
    println("test main method out of a class")
}