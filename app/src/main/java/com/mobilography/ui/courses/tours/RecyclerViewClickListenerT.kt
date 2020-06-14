package com.mobilography.ui.courses.tours

import android.view.View
import com.mobilography.data.model.Tour

interface RecyclerViewClickListenerT {
    fun onRecyclerViewItemClickT(view: View, tour:Tour)
}