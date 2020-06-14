package com.mobilography

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
//import com.mobilography.util.toast
import kotlinx.android.synthetic.main.activity_log_in.*

class LogIn : AppCompatActivity() {

    private val auth by lazy {
        FirebaseAuth.getInstance()
    }

    private val users by lazy {
        FirebaseFirestore.getInstance().collection("users")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        setupViews()
    }

    private fun signIn(
        email: String,
        password: String
    ) {
        auth.signInWithEmailAndPassword(
            email, password
        ).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                users.document(task.result?.user?.uid!!)
                    .addSnapshotListener { documentSnapshot, _ ->
                        val user = documentSnapshot?.toObject(User::class.java)

                        Log.d("taaag", user.toString())
                    }
            }
        }
    }

    fun setupViews() {
        if (auth.currentUser != null) {
            startActivity(Intent(this, Menu::class.java))
            finish()
        }
        signin.setOnClickListener {
            auth.signInWithEmailAndPassword(
                signin_email.text.toString(),
                signin_password.text.toString()
            )
                .addOnCompleteListener { task ->

                    if (task.isSuccessful) {
                        startActivity(Intent(this, Menu::class.java))

                        return@addOnCompleteListener
                    }
                        Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG).show()
                        finish()


                    }
                }
            signup.setOnClickListener {
                startActivity(Intent(this, Register::class.java))

            }
    }
}

