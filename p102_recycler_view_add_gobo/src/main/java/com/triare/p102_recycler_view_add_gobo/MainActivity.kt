package com.triare.p102_recycler_view_add_gobo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.triare.p101_recycler_view.DummyNameStorage
import com.triare.p102_recycler_view_add_gobo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    private val adapter = GoboAdapter()
    private val imageId= listOf(R.drawable.africa_cheetah,
        R.drawable.africa_crocodile,R.drawable.africa_dancers,R.drawable.africa_elephant,R.drawable.africa_giraffes,
        R.drawable.africa_sun,R.drawable.africa_zebras,R.drawable.elephant)
        var index=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        binding.apply {
            recyclerView.layoutManager=GridLayoutManager(this@MainActivity,3)
            recyclerView.adapter=adapter
            buttonAdd.setOnClickListener{
                if (index>7) index=0
                val gobo=Gobo(imageId[index], DummyNameStorage.random())
                adapter.addGobo(gobo)
                index++
            }
        }
    }
}