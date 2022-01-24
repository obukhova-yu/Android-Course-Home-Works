package com.triare.room.data.db.dao

import androidx.room.*
import com.triare.room.data.db.model.UserDbo
import com.triare.room.data.db.model.UserMinimum

// CRUD
@Dao
interface UserDao {

    // Read
    @Query("SELECT * FROM users")
    fun getAll(): List<UserDbo>

    @Query("SELECT * FROM users WHERE id = :id LIMIT 1")
    fun get(id: Int): UserDbo?

    @Query("SELECT firstName, lastName FROM users WHERE id = :id LIMIT 1")
    fun getUserMinimum(id: Int): UserMinimum?

    @Query("SELECT * FROM users WHERE lastName = :lastName")
    fun get(lastName: String): List<UserDbo>

    // Create
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userDbo: UserDbo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<UserDbo>)

    // Update
    @Update
    fun update(userDbo: UserDbo)

    @Update
    fun updateAll(users: List<UserDbo>)

    // Delete
    @Delete
    fun delete(userDbo: UserDbo)

    // Delete All
    @Query("DELETE FROM users")
    fun deleteAll()

}