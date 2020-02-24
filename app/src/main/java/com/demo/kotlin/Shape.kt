package com.demo.kotlin

abstract class Shape(private val point:List<Double>) {
    val perimeter:Double get() = point.sum()
    abstract fun calculate():Int
}