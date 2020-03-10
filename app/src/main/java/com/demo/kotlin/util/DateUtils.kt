package com.demo.kotlin.util

import java.util.*

/**
 * 整个静态类的编写
 */
object DateUtils {
    const val TAG:String = "DateUtils"
    val extra :String= "info"
    fun getTime():String{
        return Date().time.toString()
    }
}