package com.mobilography.adapter



import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mobilography.R
import com.mobilography.data.model.Course
import com.mobilography.databinding.ItemBinding
import com.mobilography.ui.courses.RecyclerViewClickListener


class MyCourseAdapter(
    private val course:List<Course>,
    private val listener: RecyclerViewClickListener
):  RecyclerView.Adapter<MyCourseAdapter.MyViewHolder>() {

    override fun getItemCount() = course.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyViewHolder (
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemBinding.courses = course[position]
        holder.itemBinding.courseCard.setOnClickListener{
            listener.onRecyclerViewItemClick(holder.itemBinding.courseCard,course [position])
        }

    }

    inner class MyViewHolder (
        val itemBinding: ItemBinding
    ):RecyclerView.ViewHolder(itemBinding.root)


}