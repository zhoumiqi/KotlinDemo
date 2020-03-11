package com.demo.kotlin

/**
 * 构造方法演示
 * 主构造方法,跟在类名后面,没有方法体,只能有一个主构造方法
 */
class ConstructorModel constructor(val name: String) {
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
}