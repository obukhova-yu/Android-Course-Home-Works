package com.triare.p071module

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    var viewModel:MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val factory = MainViewModelFactory(1)

        viewModel=ViewModelProvider(this,factory).get(MainViewModel::class.java)
        viewModel?.goboModel?.observe(this){

            findViewById<TextView>(R.id.main_title).setText(it.title.toString())
            findViewById<ImageView>(R.id.main_pickture).setImageResource(it.icon)
            findViewById<TextView>(R.id.main_description).setText(it.descr.toString())

        }
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