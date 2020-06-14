package com.mobilography.Fragment

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat.startActivityForResult
import com.bumptech.glide.Glide
import com.google.common.io.ByteArrayDataOutput
import com.google.firebase.storage.FirebaseStorage
import com.mobilography.R
import com.mobilography.util.FirestoreUtil
import com.mobilography.util.StorageUtil
import kotlinx.android.synthetic.main.fragment_user.*
import kotlinx.android.synthetic.main.fragment_user.imageView_profile_picture
import kotlinx.android.synthetic.main.fragment_user.view.*
import java.io.ByteArrayOutputStream


class FragmentUser : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false)

    }






}
