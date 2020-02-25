package com.demo.kotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.extensions.CacheImplementation
import kotlinx.android.extensions.ContainerOptions
import kotlinx.android.synthetic.main.activity_main.*

/**
 * reference:
 * https://kotlinlang.org/docs/tutorials/android-plugin.html
 */
//findViewById() will be called twice
@ContainerOptions(cache = CacheImplementation.NO_CACHE)
class MainActivity : AppCompatActivity() {
    fun goToDataBindingActivity(view: View) = startActivity<Class<Activity>>()

    private fun <T> startActivity() {
        startActivity(Intent(this@MainActivity,DataBindingActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_login.setOnClickListener {
            tv_name.text = "点击了按钮"
            startActivity<DataBindingActivity>()

        }

    }

    //findViewById() is only invoked once:
    fun MainActivity.a() {
        tv_name.text = "hidden view"
        tv_name.visibility = View.VISIBLE
    }


}
