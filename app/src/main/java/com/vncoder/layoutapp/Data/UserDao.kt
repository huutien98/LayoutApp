package com.vncoder.layoutapp.Data

import androidx.room.*
import com.vncoder.layoutapp.Model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM account_table where mail = :mail and password= :password")
    fun getUser(
        mail: String?,
        password: String?
    ): User?

    @Query("SELECT * FROM account_table ORDER BY id ASC")
    suspend fun getAllUser(): List<User>

    @Query("SELECT * FROM ACCOUNT_TABLE WHERE name LIKE :name")
    suspend fun findUserByTitle(name: String): User

    @Insert
    fun insert(user: User?)

    @Update
    fun update(user: User?)

    @Delete
    fun delete(user: User?)
}