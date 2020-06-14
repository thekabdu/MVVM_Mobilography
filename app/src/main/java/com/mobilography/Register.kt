package com.mobilography


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {


    private val auth by lazy { FirebaseAuth.getInstance() }
    private val database by lazy { FirebaseFirestore.getInstance()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        //supportActionBar!!.title = "Register"
        //supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        initialize()
    }

    fun initialize(){
        signup.setOnClickListener {
            signUp(singup_email.text.toString(),signup_password.text.toString(),signup_name.text.toString(),signup_surname.text.toString())
        }

        sign_in.setOnClickListener{
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
        }
    }

    fun signUp(
        email:String,
        password:String,
        name:String,
        surname:String

    ){
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener {task ->
                if(task.isSuccessful){
                    //do smth
                    val user:User = User(auth.currentUser!!.uid,email,name,surname)
                    database.collection("users").add(user)

                    startActivity(Intent(this, LogIn::class.java))
                    finish()
                    return@addOnCompleteListener
                }
                Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG).show()
                finish()
            }


    }
}
