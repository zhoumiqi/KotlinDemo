package com.demo.kotlin

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

data class LoginResponse(var msg: String): BaseObservable() {

    private var code: Int = 0

    @Bindable
    fun getCode(): Int = code

    fun setCode(code:Int){
        this.code = code
        notifyPropertyChanged(BR.code)
    }
}