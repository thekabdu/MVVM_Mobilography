package com.mobilography.Fragment

import android.annotation.TargetApi
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil.setContentView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.mobilography.R
import com.mobilography.User
import com.mobilography.message.item.ChatActivity
import com.mobilography.message.item.Message
import com.mobilography.message.item.MessageAdapter
import com.mobilography.util.FirestoreUtil
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_people.*
import kotlinx.android.synthetic.main.fragment_people.view.*
import java.util.*
import kotlin.collections.ArrayList


class FragmentPeople : Fragment() {

    /*override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_people, container, false)

        view.apply {
            chatgo.setOnClickListener {
                val intent: Intent = Intent(activity, ChatActivity::class.java)
                startActivity(intent)

                Toast.makeText(requireContext(), "Chat is Clicked", Toast.LENGTH_LONG).show()
            }
        }
        return view
    }*/

}
