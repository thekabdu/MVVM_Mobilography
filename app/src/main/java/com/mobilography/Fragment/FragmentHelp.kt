package com.mobilography.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.mobilography.R
import com.mobilography.TourCardHelp
import kotlinx.android.synthetic.main.fragment_help.*


class FragmentHelp : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v =  inflater.inflate(R.layout.fragment_help, container, false)
        v.apply {
            textView3.setOnClickListener {
                val intent: Intent = Intent(activity, TourCardHelp::class.java)
                startActivity(intent)

                Toast.makeText(requireContext(), "FAQ is Clicked", Toast.LENGTH_LONG).show()
            }
        }
        return view
    }


}
