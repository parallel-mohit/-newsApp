package com.example.intern

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.Gallery
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class uploadImgActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration:AppBarConfiguration
    lateinit var imgView:ImageView
    lateinit var navController: NavController
    lateinit var toolbar:Toolbar
    lateinit var slectbtn:Button
    lateinit var upldImg:Button
    private val contract =registerForActivityResult(ActivityResultContracts.GetContent()){
        imgView.setImageURI(it)
    }
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_img)
        imgView=findViewById<ImageView>(R.id.upldImg)
        slectbtn=findViewById<Button>(R.id.selectimg)
        upldImg=findViewById<Button>(R.id.upldimg)
        toolbar=findViewById(R.id.tlbr)
        slectbtn=findViewById<Button>(R.id.selectimg)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        slectbtn.setOnClickListener {
            contract.launch("image/*")
        }

    }

}