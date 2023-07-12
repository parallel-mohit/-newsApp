package com.example.intern

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController



class basicFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if(onBoardingFinished()){
            findNavController().navigate(R.id.action_basicFragment_to_homeFrag)
        }
        else{

            findNavController().navigate(R.id.action_basicFragment_to_intro1)
        }
        val view=inflater.inflate(R.layout.fragment_basic, container, false)
        return view
    }
    fun onBoardingFinished():Boolean {
        val sharedPreferences =requireActivity().getSharedPreferences("onBoard", AppCompatActivity.MODE_PRIVATE)
        return sharedPreferences.getBoolean("Finished",false)
    }
}