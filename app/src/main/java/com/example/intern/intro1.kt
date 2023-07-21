package com.example.intern

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class intro1 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_intro1, container, false)
        val btn=view.findViewById<Button>(R.id.ready1)
        btn.setOnClickListener {
            findNavController().navigate(R.id.action_intro1_to_intro2)
        }
        val skipbtn1=view.findViewById<Button>(R.id.skip1)
        skipbtn1.setOnClickListener {
            findNavController().navigate(R.id.action_intro1_to_homeFrag)
        }
        return view

    }



}