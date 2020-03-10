package com.demo.kotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle

/**
 * 全局使用的常量以及扩展函数
 * 直接写在 kt 文件中，和写在 class UserUtil 类中的区别：
 * 编译结果跟 Java 静态工具类的写法没什么区别，你要非说区别的话，
 * 那就是 类 和 方法 都多了一个 final 修饰符。。
 */
const val API_KEY = "feaefea"

fun <T> goToPage(context: Context, clazz: Class<T>, bundle: Bundle) {
    val intent: Intent = Intent(context, clazz)
    intent.putExtra("bundle", bundle)
    context.startActivity(intent)
}