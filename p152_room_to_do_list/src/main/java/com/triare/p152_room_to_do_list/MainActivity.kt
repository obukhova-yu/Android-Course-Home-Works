package com.triare.p152_room_to_do_list

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton


class MainActivity : AppCompatActivity() {


   lateinit var addButton: MaterialButton

    @SuppressLint("UseCompatLoadingForDrawables")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        initAddButton()


    }

    private fun initAddButton() {
        addButton = findViewById(R.id.add_button_main_activity)
        addButton.setOnClickListener(){
            val intentTask = Intent(this, TaskCreationActivity::class.java)
            startActivity(intentTask)
            Toast.makeText(this,"button",Toast.LENGTH_LONG).show()
            }


    }



}