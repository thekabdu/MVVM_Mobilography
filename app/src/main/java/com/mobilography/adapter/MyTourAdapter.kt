package com.mobilography.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import androidx.recyclerview.widget.RecyclerView
import com.mobilography.R
import com.mobilography.data.model.Tour
import com.mobilography.databinding.ItemtourBinding
import com.mobilography.ui.courses.tours.RecyclerViewClickListenerT

class MyTourAdapter(
    private val tour:List<Tour>,
    private val listenert: RecyclerViewClickListenerT
): RecyclerView.Adapter<MyTourAdapter.MyViewHolderT>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyViewHolderT (
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.itemtour,
                parent,
                false
            )

    )

    override fun getItemCount() = tour.size

    override fun onBindViewHolder(holder: MyViewHolderT, position: Int) {
        holder.itemtourBinding.tours = tour[position]
        holder.itemtourBinding.tourCard.setOnClickListener{
            listenert.onRecyclerViewItemClickT(holder.itemtourBinding.tourCard,tour [position])
        }
    }

    inner class MyViewHolderT (
        val itemtourBinding: ItemtourBinding
    ):RecyclerView.ViewHolder(itemtourBinding.root)


}
