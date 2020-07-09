package com.vncoder.layoutapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.vncoder.layoutapp.Data.UserDao
import com.vncoder.layoutapp.Data.UserDataBase
import com.vncoder.layoutapp.Model.User
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {

    var userDao: UserDao? = null

    var fullname: String? = null
    var emailAddress: String? = null
    var password: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        userDao = Room.databaseBuilder<UserDataBase>(this, UserDataBase::class.java, "account.db")
            .allowMainThreadQueries()
            .build()
            .userDao

        tv_signin.setOnClickListener {
            val intentSignIn = Intent(baseContext, MainActivity::class.java)
            startActivity(intentSignIn)
            finish()
        }
        btn_sign_up.setOnClickListener {
            fullname = full_name.getText().toString().trim({ it <= ' ' })
            emailAddress = mail_Address.getText().toString().trim({ it <= ' ' })
            password = edtpassword.getText().toString().trim({ it <= ' ' })

            val pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}"

            if (fullname!!.isEmpty()&& emailAddress!!.isEmpty() && password!!.isEmpty() && password!!.matches(pattern.toRegex())== false)
            {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("ERROR")
                builder.setMessage("User Name,mail,password Can't Is Empty!")
                builder.setCancelable(false)
                builder.setPositiveButton("Ok") { dialogInterface, i -> Toast.makeText(this,
                    "You need to enter enough information".trimIndent(), Toast.LENGTH_SHORT).show() }
                val alertDialog = builder.create()
                alertDialog.show()
            } else {
                val user = User(fullname!!, password!!, emailAddress!!)
                userDao!!.insert(user)
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("User", user)
                startActivity(intent)
            }

        }

    }
}