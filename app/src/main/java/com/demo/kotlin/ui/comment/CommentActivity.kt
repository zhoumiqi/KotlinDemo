package com.demo.kotlin.ui.comment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.demo.kotlin.R
import com.demo.kotlin.databinding.ActivityCommentBinding
import kotlinx.android.synthetic.main.activity_comment.*

class CommentActivity : AppCompatActivity() {
    var binding: ActivityCommentBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_comment)
        binding?.commentVM = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(CommentViewModel::class.java)
        binding?.lifecycleOwner = this
//        binding?.commentVM?.comment?.observe(this, Observer {
//            Log.e("CommentActivity", it)
//        })
        et_input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                binding?.commentVM?.comment?.value = s?.toString()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })

    }
}