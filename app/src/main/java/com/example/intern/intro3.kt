package com.example.intern

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class intro3 : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_intro3, container, false)
        val btn=view.findViewById<Button>(R.id.ready3)
        btn.setOnClickListener {

            findNavController().navigate(R.id.action_intro3_to_homeFrag)

        }
        val skipbtn=view.findViewById<Button>(R.id.skip3)
        skipbtn.setOnClickListener {
            findNavController().navigate(R.id.action_intro3_to_homeFrag)
        }
        return view

    }

}