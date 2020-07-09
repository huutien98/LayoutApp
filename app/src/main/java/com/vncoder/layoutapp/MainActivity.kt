package com.vncoder.layoutapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.vncoder.layoutapp.Data.UserDao
import com.vncoder.layoutapp.Data.UserDataBase
import com.vncoder.layoutapp.Model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var db: UserDao? = null
    var dataBase: UserDataBase? = null
    var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        user = intent.getSerializableExtra("User") as User?
        if (user != null) {
            editTextmail.setText(user!!.mail)
            editText2.setText(user!!.password)
        }

        dataBase = Room.databaseBuilder(this, UserDataBase::class.java, "account.db")
            .allowMainThreadQueries()
            .build()
        db = dataBase!!.userDao

        tv_signup.setOnClickListener {
            val intentSignUp = Intent(baseContext, MainActivity2::class.java)
            startActivity(intentSignUp)
            finish()
        }

        btn_back.setOnClickListener { showAlertDialog() }

        tv_forgotPassword.setOnClickListener {
            val url = "https://www.google.com.vn"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        button.setOnClickListener {
            val mail = editTextmail.text.toString().trim { it <= ' ' }
            val password = editText2.text.toString().trim { it <= ' ' }
            val user = db!!.getUser(mail, password)
            if (user != null) {
                val intent = Intent(this@MainActivity, MainActivity3::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(baseContext, "mail or password not correct", Toast.LENGTH_LONG
                ).show()
            }
        }

        btn_back.setOnClickListener { showAlertDialog() }

    }

    override fun onBackPressed() {
        showAlertDialog()
    }

    fun showAlertDialog() {
        val builder =
            AlertDialog.Builder(this)
        builder.setTitle("Monstarlab lifeTime")
        builder.setMessage("Do you want exit app?")
        builder.setCancelable(false)
        builder.setPositiveButton(
            "No"
        ) { dialogInterface, i ->
            Toast.makeText(this@MainActivity, "thank you", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton(
            "Yes"
        ) { dialogInterface, i ->
            Toast.makeText(applicationContext, "see you again", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
            System.exit(0)
        }
        val alertDialog = builder.create()
        alertDialog.show()
    }
}