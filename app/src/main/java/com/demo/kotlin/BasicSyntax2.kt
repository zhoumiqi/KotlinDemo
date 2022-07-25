package com.demo.kotlin

/**
 * ref:https://kotlinlang.org/docs/basic-syntax.html
 */
class BasicSyntax2 {
    //Read-only local variables are defined using the keyword val,They can be assigned a value only once.
    //只读局部变量用val关键字修饰，只能被赋值一次
    //Variables that can be reassigned use the var keyword
    //普通变量用var关键字修饰,可以被多次赋值
    fun add(a:Int,b:Int):Int{
        return a+b
    }

    fun add2(a:Int,b: Int) = a+b
    //条件表达式
    fun max(a: Int,b: Int):Int{
//        if(a>b){
//            return a
//        } else {
//            return b
//        }
        //等价于
        return if (a>b) a else b
    }

    //循环
    fun forLoop(){
        val list = listOf("hello", "world")
        for (str in list) {
            println(str)
        }
        for (index in list.indices) {
            println("index = $index,value = ${list[index]}")
        }
        var index = 0
        while (index<list.size) {
            println(list[index])
            index++
        }
    }

    //条件语句,判断类型用is 或者!is
    fun condition(obj:Any):String =
        when(obj){
            1 ->"type = $obj"
            2 -> "type = $obj,but"
            "cmd" -> "string"
            is Int -> "is Int type"
            !is String -> "is not String"
            else -> "default value"
        }
    //范围,判断范围用in 或者!in
    fun rang(){
        val index = 3
        if (index in 1..9) {
            print("this is right")
        }
        val list = listOf("this", "is")
        if (4 !in 0..list.size) {
            print("4 is not in rang 0~size")
        }

        for (x in 1..5) {
            print(x)//print 12345
        }
        for (z in 1..9 step 2) {
            print(z)
        }
        for (y in 9 downTo 1 step 3) {
            print(y) ///print 54321
        }

    }

    //集合遍历 用in
    fun iteratorCollection(){
        val list = listOf("hello", "world")
        for (item in list){
            println(item)
        }

    }
    //检查集合中是否包含某个对象 用in
    fun checkItem(){
        val list = listOf("hello", "world","tom")
        val result = when{
            "world" in list -> true
            "hello" in list -> true
            else -> false
        }
        //等价于
        //list.contains("world")
    }

}