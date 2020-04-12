package com.demo.kotlin.ui.comment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CommentViewModel:ViewModel() {
    var comment = MutableLiveData<String>()
}