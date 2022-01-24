package com.triare.room

import androidx.lifecycle.ViewModel
import com.triare.room.data.repository.UserRepository
import com.triare.room.dummy.UserDummy

class MainViewModel : ViewModel() {

    private val userRepository = UserRepository()

    fun add() {
        userRepository.addUser(UserDummy.randomUser())
    }

    fun deleteAll() {
        userRepository.deleteAll()
    }

}