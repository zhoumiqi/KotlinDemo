package com.demo.kotlin

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutinesTest {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            GlobalScope.launch {
                delay(1000)
                println("world!")
            }
            println("hello ")
            Thread.sleep(2000)
        }
    }
}