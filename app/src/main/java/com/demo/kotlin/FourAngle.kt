package com.demo.kotlin

class FourAngle(private val value1:Double, private val value2:Double, private val value3:Double) : Shape(listOf(value1,value2,value3)),OnAreaClickListener {
    override fun calculate(): Int {
        return value1.coerceAtLeast(maxOf(value2, value3)).toInt()
    }

    override fun onClick() {
        println("FourAngle onClick invoked")
    }
}