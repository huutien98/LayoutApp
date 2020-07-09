package com.vncoder.layoutapp.Data

import androidx.room.*
import com.vncoder.layoutapp.Model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM User where mail = :mail and password= :password")
    fun getUser(
        mail: String?,
        password: String?
    ): User?

    @Insert
    fun insert(user: User?)

    @Update
    fun update(user: User?)

    @Delete
    fun delete(user: User?)
}