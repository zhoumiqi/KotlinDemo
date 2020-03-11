package com.demo.kotlin.util

import java.util.*

/**
 * 整个静态类的编写
 * 用object 修饰的类为静态类，里面的方法和变量都为静态的。
 */
object DateUtils {
    const val TAG:String = "DateUtils"
    val extra :String= "info"
    fun getTime():String{
        return Date().time.toString()
    }
}