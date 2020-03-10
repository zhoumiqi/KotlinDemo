package com.demo.kotlin.util
/**
 * 类中的部分静态方法
 */
class Const {
    //companion object {}中用来修饰 静态常量，或者静态方法，单例等等
    /**
     * 匿名伴生类
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

    fun normalFunction(){

    }
}