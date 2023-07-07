package com.example.intern

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class intro2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.fragment_intro2, container, false)
        val btn=view.findViewById<Button>(R.id.ready2)
        btn.setOnClickListener {
            findNavController().navigate(R.id.action_intro2_to_intro3)
        }
        val skipbtn=view.findViewById<Button>(R.id.skip2)
        skipbtn.setOnClickListener {
            findNavController().navigate(R.id.action_intro2_to_homeFrag)
        }
        return view
    }

}