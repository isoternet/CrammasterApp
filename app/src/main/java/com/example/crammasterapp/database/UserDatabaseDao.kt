package com.example.crammasterapp.database

import androidx.room.*

// TODO enable coroutines?

@Dao
interface UserDatabaseDao {

    @Insert
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Query("SELECT * FROM user_credentials_table WHERE username = :key")
    fun get(key: String): User?

    @Query("SELECT * FROM user_credentials_table ORDER BY username DESC")
    fun getAllUsers(): List<User>

    @Query("DELETE FROM user_credentials_table")
    fun clear()
}