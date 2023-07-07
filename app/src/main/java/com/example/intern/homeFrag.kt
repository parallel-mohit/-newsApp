package com.example.intern

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.intern.feedimage.feedActivity


class homeFrag : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view= inflater.inflate(R.layout.fragment_home, container, false)
        val feedbtn=view.findViewById<Button>(R.id.feed)
        val uplbtn=view.findViewById<Button>(R.id.upldImg)
        feedbtn.setOnClickListener {
            activity?.let {
                startActivity(Intent(activity, feedActivity::class.java))
            }

        }
        uplbtn.setOnClickListener {
            activity?.let {
                startActivity(Intent(activity,uploadImgActivity::class.java))
            }
        }
        return view
    }


}