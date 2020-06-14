package com.mobilography.util

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.mobilography.LogIn
import com.mobilography.Menu




fun Context.logout() {
    val intent = Intent(this, LogIn::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }
    startActivity(intent)
}