package com.demo.kotlin

import android.content.Context
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import java.io.Serializable


data class User(var userName: ObservableField<String>, var password: ObservableField<String>) :
    Serializable {
    var age: ObservableInt = ObservableInt(0)
    var userInfo: ObservableField<String> =
        ObservableField(userName.get() + "," + password.get() + "," + age.get())

    fun printMsg() {
        println("printMsg invoke")
    }
}