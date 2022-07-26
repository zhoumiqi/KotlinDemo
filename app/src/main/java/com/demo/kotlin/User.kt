package com.demo.kotlin

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.io.Serializable

/**
 * Create a POJO with getters, setters, `equals()`, `hashCode()`, `toString()` and `copy()` in a single line:
 */
data class User(var userName: ObservableField<String>, var password: ObservableField<String>) :
    Serializable {
    var age: ObservableInt = ObservableInt(0)
    var userInfo: ObservableField<String> =
        ObservableField(userName.get() + "," + password.get() + "," + age.get())
    var name = MutableLiveData<String>()
    val display by lazy {
        //compute the String
    }
    fun printMsg() {
        println("printMsg invoke")
    }
}