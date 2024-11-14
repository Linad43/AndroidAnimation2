package com.example.androidanimation2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment

class MainFragment : Fragment() {

    private lateinit var beginBTN: Button
    private lateinit var imageIV: ImageView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageIV = view.findViewById(R.id.imageIV)
        beginBTN = view.findViewById(R.id.beginBTN)

        val animationImage =
            AnimationUtils.loadAnimation(activity?.applicationContext, R.anim.occurence)
        imageIV.startAnimation(animationImage)
        val animationBTN =
            AnimationUtils.loadAnimation(activity?.applicationContext, R.anim.move_left_to_center)
        beginBTN.startAnimation(animationBTN)
        beginBTN.setOnClickListener {
            fragmentManager
                ?.beginTransaction()
                ?.add(R.id.containerFragment, SignUpFragment())
                ?.addToBackStack("")
                ?.commit()
        }
    }

}