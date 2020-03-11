package com.demo.kotlin.util

/**
 * 类中的部分静态方法
 */
class Const {
    val TAG:String= ""
    /**
     * 匿名伴生类
     * companion object {}中用来修饰 静态常量，或者静态方法，单例等等
     */
    companion object {
        const val URL = "https://www.github.com"
        var key: String = "aes"
        fun getParam() = "{code:1,msg:success}"

        @JvmField
        var result: String = "result"

        @JvmStatic
        fun getHost() = "www.github.com"

        @JvmStatic
        fun main(args: Array<String>) {
            println("this is test main function")
        }
    }

    /**
     * 使用object声明静态内部类
     * 类内部的对象声明，没有被inner 修饰的内部类都是静态的
     */
    object InnerStaticClass {
        fun  test():String{
            getParam()
            return URL
        }
    }

    /**
     * 内部类
     */
    class InnerClass {
        fun test(){
            getParam()
        }
    }

    /**
     * 内部类
     */
    inner class InnerClass2{
        fun test(){
            getParam()
            TAG
        }
    }

    fun normalFunction() {
        getParam()
        TAG
    }
}