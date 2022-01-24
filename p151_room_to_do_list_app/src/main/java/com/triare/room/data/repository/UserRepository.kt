package com.triare.room.data.repository

import com.triare.room.data.db.AppDatabase
import com.triare.room.data.db.model.UserDbo

class UserRepository {

    private val db = AppDatabase.getInstance()
    private val userDao = db.userDao()

    fun getUsers() = userDao.getAll()

    fun addUser(userDbo: UserDbo) {
        userDao.insert(userDbo)
    }

    fun deleteAll() {
        userDao.deleteAll()
    }

}