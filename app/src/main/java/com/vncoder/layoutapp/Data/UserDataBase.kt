package com.vncoder.layoutapp.Data

import android.content.Context
import android.content.res.Resources
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vncoder.layoutapp.Model.User
import kotlinx.coroutines.CoroutineScope

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao?

    companion object{
        @Volatile
            private var INSTANCE: UserDataBase? = null

            fun getData(context: Context):UserDataBase?{
                val tempInstance = INSTANCE
                if (tempInstance!=null) {
                    return tempInstance
                }
                synchronized(this){
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDataBase::class.java,
                        "app_database"
                    ).run { allowMainThreadQueries() }.build()
                    INSTANCE = instance
                    return instance
                }
            }

    }

}