package com.mobilography.message.item

import android.annotation.SuppressLint
import android.graphics.Color
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.mobilography.R
import java.util.*
import kotlin.collections.ArrayList

class MessageAdapter(private val messages: ArrayList<Message>) :
    RecyclerView.Adapter<MessageAdapter.ViewHolder>() {
    private val database by lazy { FirebaseFirestore.getInstance() }
    private val auth by lazy { FirebaseAuth.getInstance() }
    private var s = ""
    fun update(new_messages: ArrayList<Message>){
        this.messages.clear()
        messages.addAll(new_messages)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_people, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(messages[position].user?.id == auth.currentUser?.uid.toString()){
            holder.itemView.setBackgroundColor(Color.CYAN)
        }
        holder.senderName.text = messages[position].user?.name
        holder.timestamp.text = messages[position].timestamp
        holder.text.text = messages[position].text
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var senderName: TextView = itemView.findViewById(R.id.name_user)
        var timestamp: TextView = itemView.findViewById(R.id.time)
        var text: TextView = itemView.findViewById(R.id.messages)

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

    private fun getUserName(senderId: String): String{
        database.collection("users").whereEqualTo("uid", senderId).get()
            .addOnSuccessListener{ querySnapshot ->
                s = querySnapshot.documents[0].get("username").toString()
            }
        return s
    }

}