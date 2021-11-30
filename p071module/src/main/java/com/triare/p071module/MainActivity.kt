package com.triare.p071module

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private var viewModel:MainViewModel? = null

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel?.goboModel?.observe(this, Observer {

            if (it != null) {

                findViewById<TextView>(R.id.main_title).setText(it.title)
                findViewById<ImageView>(R.id.main_pickture).setImageDrawable(getDrawable(it.icon))
                findViewById<TextView>(R.id.main_description).setText(it.descr)

            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {

        val radio1=findViewById<RadioButton>(R.id.radio_1)
        val radio2=findViewById<RadioButton>(R.id.radio_2)

        menu?.setGroupVisible(R.id.group1,radio1.isChecked())
        menu?.setGroupVisible(R.id.group2,radio2.isChecked())

        return super.onPrepareOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
         viewModel?.add(item.itemId)
        return super.onOptionsItemSelected(item)
    }
}