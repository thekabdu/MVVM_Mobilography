package com.mobilography.message.item

import android.annotation.TargetApi
import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.mobilography.R
import com.mobilography.User
import kotlinx.android.synthetic.main.activity_chat.*
import java.util.*
import kotlin.collections.ArrayList



class ChatActivity : AppCompatActivity() {
    var messages: ArrayList<Message> = ArrayList()
    private lateinit var messageAdapter: MessageAdapter
    private val auth by lazy { FirebaseAuth.getInstance() }
    private val database by lazy { FirebaseFirestore.getInstance() }

    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        fillMessages()
        my_recycler_view!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        messageAdapter = MessageAdapter(messages)
        my_recycler_view!!.adapter = messageAdapter
        (messageAdapter as MessageAdapter).update(messages)
        btnSend.setOnClickListener { sendMessage() }

    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun fillMessages() {
        val coll = database.collection("messages")
        coll.orderBy("date").addSnapshotListener { snapshot, e ->
            var temparray = ArrayList<Message>()
            for (document in snapshot!!.documents) {
                val senderId = document.get("senderId").toString()
                val text = document.get("message").toString()
                val date = document.get("date") as Double

                val convertedDate = getStringTime(date.toLong())
                database.collection("users")
                    .whereEqualTo("uid", senderId)
                    .addSnapshotListener { snapshot1, e1 ->
                        for (document1 in snapshot1!!.documents) {
                            snapshot1.documents[0]
                            val data = document1.data
                            if (data != null) {
                                val name = data["name"].toString()
                                val id = data["uid"].toString()
                                val email = data["email"].toString()
                                val surname = data["surname"].toString()
                                Log.d("Taaaag", data.toString())
                                val user = User(name = name, id = id, email = email, surname = surname)
                                val message =
                                    Message(user = user, text = text, timestamp = convertedDate)
                                temparray.add(message)
                            }
                        }
                        messages.clear()
                        messages.addAll(temparray)
                        messageAdapter?.notifyDataSetChanged()
                    }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun sendMessage() {
        if (et_chat.text.toString() != "") {
            val timeStamp = Timestamp.now().seconds.toDouble()
            val senderId = auth.currentUser?.uid.toString()
            val data = hashMapOf(
                "senderId" to senderId,
                "message" to et_chat.text.toString(),
                "date" to timeStamp
            )
            database.collection("messages")
                .add(data)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        et_chat.text.clear()
                        return@addOnCompleteListener
                    }
                    Toast.makeText(this, task.exception.toString(), Toast.LENGTH_LONG).show()
                }
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun getStringTime(time: Long): String {
        return try {
            val DF = SimpleDateFormat("dd.MM.yyyy hh:mm")
            val date = Date(time * 1000)
            DF.format(date)
        } catch (e: Exception) {
            e.toString()
        }
    }
}
