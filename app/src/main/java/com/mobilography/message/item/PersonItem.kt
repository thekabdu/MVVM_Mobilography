package com.mobilography.message.item


import android.content.Context
import com.mobilography.R
import com.mobilography.User
import com.mobilography.util.StorageUtil
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_person.*

class PersonItem(val person: User,
                 val userId: String,
                 private val context: Context)
    : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView_name.text = person.name
        viewHolder.textView_bio.text = person.email

    }

    override fun getLayout() = R.layout.item_person
}