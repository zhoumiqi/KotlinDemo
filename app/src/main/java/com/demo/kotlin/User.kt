package com.demo.kotlin

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import java.io.Serializable


data class User(var userName: ObservableField<String>, var password: ObservableField<String>) :
    Serializable {
    var age: ObservableInt = ObservableInt(0)
    var userInfo: ObservableField<String> =
        ObservableField(userName.get() + "," + password.get() + "," + age.get())
}