package com.example.androidanimation2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.androidviewpager.service.CommonFun

class SignUpFragment : Fragment() {

    private lateinit var toolbar: Toolbar
    private lateinit var layoutSignUp: LinearLayout
    private lateinit var loginET: EditText
    private lateinit var passwordET: EditText
    private lateinit var signUpBTN: Button
    private lateinit var onFragmentDataListner: OnFragmentDataListner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar = view.findViewById(R.id.toolbar)
        layoutSignUp = view.findViewById(R.id.layoutSignUp)
        loginET = view.findViewById(R.id.loginET)
        passwordET = view.findViewById(R.id.passwordET)
        signUpBTN = view.findViewById(R.id.signUpBTN)
        onFragmentDataListner = requireActivity() as OnFragmentDataListner
        val allET = arrayListOf(
            loginET,
            passwordET
        )

        toolbar.startAnimation(
            AnimationUtils.loadAnimation(
                activity?.applicationContext,
                R.anim.move_up_to_up
            )
        )
        layoutSignUp.startAnimation(
            AnimationUtils.loadAnimation(
                activity?.applicationContext,
                R.anim.move_down_to_up
            )
        )
        signUpBTN.setOnClickListener {
            if (CommonFun.allETIsNotEmpty(allET)) {
                onFragmentDataListner.onData(loginET.text.toString())
            }
        }
    }
}