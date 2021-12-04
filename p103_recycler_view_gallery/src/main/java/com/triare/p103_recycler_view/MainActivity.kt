package com.triare.p103_recycler_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.random.Random
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.triare.p103_recycler_view.GalleryAdapter
import com.triare.p103_recycler_view.GalleryStorage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = GalleryAdapter(GalleryStorage.getRandom(this))
    }
}
