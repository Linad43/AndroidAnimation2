package com.example.androidviewpager.service

import android.widget.EditText
import com.example.androidanimation2.R


class CommonFun {
    companion object {
        fun allETIsNotEmpty(allET: ArrayList<EditText>): Boolean {
            var flag = true
            allET.forEach {
                if (it.text.isEmpty()) {
                    flag = false
                    it.setHint(R.string.isDoNotEmpty)
                }
            }
            return flag
        }
    }
}