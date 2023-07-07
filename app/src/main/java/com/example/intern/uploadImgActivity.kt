package com.example.intern

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.Gallery
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class uploadImgActivity : AppCompatActivity() {
    lateinit var imgView:ImageView
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

            slectbtn.setOnClickListener {
                contract.launch("image/*")
            }

    }
}