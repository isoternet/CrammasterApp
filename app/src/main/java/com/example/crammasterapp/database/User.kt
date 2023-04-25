package com.example.crammasterapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_credentials_table")
data class User(

    @PrimaryKey
    var username: String = "",

    @ColumnInfo(name = "password")
    var password: String = ""
)