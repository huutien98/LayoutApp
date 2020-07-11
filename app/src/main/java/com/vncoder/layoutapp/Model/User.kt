package com.vncoder.layoutapp.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "account_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo (name = "id") val id: Int? =0,
    @ColumnInfo(name = "name") val name: String? ="",
    @ColumnInfo(name = "mail") val mail: String? ="",
    @ColumnInfo(name = "password") val password: String? = ""
)

