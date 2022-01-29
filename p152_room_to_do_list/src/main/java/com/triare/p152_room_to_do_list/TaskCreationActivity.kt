package com.triare.p152_room_to_do_list

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.button.MaterialButton
import com.triare.p152_room_to_do_list.AlertDialog.MaterialAlertDialog


class TaskCreationActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private val alertDialog = MaterialAlertDialog()
    private lateinit var addButton: MaterialButton
    private lateinit var editText: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_creation)
        initToolBar()
        initAddButton()
        iniEditText()
    }

    private fun iniEditText() {
        editText = findViewById(R.id.textField)
       // editText.text = alertDialog.m_Text
    }

    private fun initToolBar() {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.tool_bar_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){

            R.id.delete_action -> {
                Toast.makeText(this,"delete",Toast.LENGTH_LONG).show()
            }
            R.id.edit_action -> {
                Toast.makeText(this,"edit",Toast.LENGTH_LONG).show()
            }
            R.id.confirm_action -> {
                Toast.makeText(this,"confirm",Toast.LENGTH_LONG).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
    private fun initAddButton() {
        addButton = findViewById(R.id.add_button_new_task)
        addButton.setOnClickListener(){
            alertDialog.createAlertDialog(this)
            Toast.makeText(this,"button",Toast.LENGTH_LONG).show()
        }
    }





}




