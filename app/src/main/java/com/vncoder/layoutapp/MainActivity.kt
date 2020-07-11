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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() ,CoroutineScope{

    private var noteDB: UserDataBase? = null

    private lateinit var mJob: Job
    override val coroutineContext: CoroutineContext
        get() = mJob + Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mJob = Job()
        noteDB = UserDataBase.getData(this)

        var string = intent.getStringExtra("mail")
            editTextmail.setText(string)


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
            val mail = editTextmail.text.toString().trim()
            val password = editText2.text.toString().trim()
            val user = noteDB?.userDao()?.getUser(mail, password)

            if (user != null) {
                val intent = Intent(this@MainActivity, MainActivity3::class.java)
                startActivity(intent)
                Toast.makeText(this,user.id.toString()+ user.mail+user.password,Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(baseContext,"mail or password not correct", Toast.LENGTH_LONG
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
        ) { dialogInterface, i -> Toast.makeText(this@MainActivity, "thank you", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton(
            "Yes"
        ) { dialogInterface, i -> Toast.makeText(applicationContext, "see you again", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
            System.exit(0)
        }
        val alertDialog = builder.create()
        alertDialog.show()
    }
}