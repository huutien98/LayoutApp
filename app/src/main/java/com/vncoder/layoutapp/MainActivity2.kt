package com.vncoder.layoutapp

import android.content.Intent
import android.os.Bundle

import android.widget.Toast
import androidx.annotation.RestrictTo
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.vncoder.layoutapp.Data.UserDataBase
import com.vncoder.layoutapp.Model.User
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.coroutines.*
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


class MainActivity2 : AppCompatActivity() ,CoroutineScope{

    private var dataUser: UserDataBase? = null

    private lateinit var mJob: Job
    override val coroutineContext: CoroutineContext
        get() = mJob + Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        tv_signin.setOnClickListener {
            val intentSignIn = Intent(baseContext, MainActivity::class.java)
            startActivity(intentSignIn)
            finish()
        }

        mJob = Job()
        dataUser = UserDataBase.getData(this)

        btn_sign_up.setOnClickListener {
            var name:String = full_name.text.toString().trim()
            var mail :String= mail_Address.text.toString().trim()
            var password:String = edtpassword.text.toString().trim()

            val pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}"
            if (name!!.isEmpty()&& mail!!.isEmpty() && password!!.isEmpty() && password!!.matches(pattern.toRegex())== false)
            {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("ERROR")
                builder.setMessage("User Name,mail,password Can't Is Empty!")
                builder.setCancelable(false)
                builder.setPositiveButton("Ok") { dialogInterface, i -> Toast.makeText(this,
                    "You need to enter enough information", Toast.LENGTH_SHORT).show() }
                val alertDialog = builder.create()
                alertDialog.show()
            } else {
                   launch{

                     dataUser?.userDao()?.insert(User(id = null,name = name,mail = mail,password = password))
                 }

                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("mail",mail)
                startActivity(intent)

            }

        }

    }
}