package com.mobilography.ui.courses

import android.view.View
import com.mobilography.data.model.Course

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClick(view: View, course:Course)
}