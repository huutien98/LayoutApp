package com.vncoder.layoutapp.Data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vncoder.layoutapp.Model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDataBase : RoomDatabase() {
    abstract val userDao: UserDao?

}