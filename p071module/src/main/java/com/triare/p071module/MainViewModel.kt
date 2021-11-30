package com.triare.p071module

import android.graphics.drawable.Icon
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel ():ViewModel(){

    val goboModel=MutableLiveData<Gobo>().apply {value=null}

    val model=Repository()

    fun add(id: Int){
        val gobo = model.getGoboById(id)
        goboModel.value=gobo
    }

}




