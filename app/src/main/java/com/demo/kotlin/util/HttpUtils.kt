package com.demo.kotlin.util

class HttpUtils {
    /**
     * 伴生类
     */
    companion object Server{
        const val RELEASE_ADDRESS = ""
        var test_address = ""
        @JvmField
        var debugHost = ""
        fun getParam():String{
            return ""
        }
        @JvmStatic
        fun getHost(){
            Const.InnerStaticClass.apply {
                println("this is a static inner class")
            }
            val innerClass = Const.InnerClass()
            val innerClass2 = Const().InnerClass2()
        }
    }
}