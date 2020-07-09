package com.vncoder.layoutapp.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class User(var userName: String, var password: String, var mail: String) :
    Serializable {
    @PrimaryKey(autoGenerate = true)
    var id = 0

    override fun toString(): String {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                '}'
    }

}