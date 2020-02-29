package com.demo.kotlin

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import com.demo.kotlin.databinding.ActivityDataBindingBinding

/**
 * reference:
 * https://kotlinlang.org/docs/tutorials/android-frameworks.html
 */
class DataBindingActivity : AppCompatActivity() {
    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityDataBindingBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_data_binding)
        user = User(ObservableField("Lucy"), ObservableField("12345"))
        user?.age?.set(234)
        binding.user = user
    }

    fun login(view: View) {
        user?.userName?.set("Rose")
        user?.password?.set("89993")
        user?.age?.set(999)
        user?.userInfo?.set(user?.userName?.get() + "," + user?.password?.get() + "," + user?.age?.get())
    }
}
