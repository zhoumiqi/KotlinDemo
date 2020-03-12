package com.demo.kotlin

import android.app.Application
import android.util.Log
import com.demo.kotlin.util.Const
import com.demo.kotlin.util.DateUtils

/**
 * constructor 私有化
 * 如果你想要确保你的类不被其他代码实例化，必须把构造方法标记为 private
 */
class MyApplication private constructor() : Application() {
    //使用陪伴对象来实现静态方法
    companion object {
        const val APP_KEY: String = "app_key"
        private var instance: MyApplication = MyApplication()
        //companion object 方法kotlin中可以直接 类.方法 调用
        //java则需要通过Companion对象间接调用
        //如果需要java也直接 类.方法 调用则可以用jvmStatic注解修饰即可
        @JvmStatic
        fun getInstance(): MyApplication {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        val time = DateUtils.getTime()
        val url = Const.URL
        val param = Const.getParam()
        Log.d(DateUtils.TAG, "MyApplication onCreate,and extra = " + DateUtils.extra)
    }

    fun init(){
        //kotlin中可以直接访问全局申明的常量(java中是类Kt.静态方法)
        val apiKey = API_KEY
    }
}