package com.demo.kotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
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
        startActivity(Intent(this@MainActivity, DataBindingActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_login.setOnClickListener {
            tv_name.text = "点击了按钮"
            startActivity<DataBindingActivity>()
        }
        //这里的object代表匿名对象类型,加上()表示显示的调用这个类的构造方法。
        //View.OnClickListener没有加，因为如果这样的话，那就和new普通的类，没什么区别的（而不是匿名内部类）
        btn_onclick.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                println("btn_onclick invoked")
                //直接访问的全局声明的扩展方法
                goToPage<DataBindingActivity>(
                    this@MainActivity, DataBindingActivity::class.java,
                    Bundle()
                )
            }
        })

    }

    //findViewById() is only invoked once:
    fun MainActivity.a() {
        tv_name.text = "hidden view"
        tv_name.visibility = View.VISIBLE
    }


}
