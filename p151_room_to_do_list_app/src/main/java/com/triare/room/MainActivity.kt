package com.triare.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.triare.room.data.db.AppDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUi()
        initViewModel()
    }

    private fun initUi() {
        val add = findViewById<Button>(R.id.add)
        val deleteAll = findViewById<Button>(R.id.deleteAll)

        add.setOnClickListener {
            viewModel.add()
        }
        deleteAll.setOnClickListener {
            viewModel.deleteAll()
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }
}