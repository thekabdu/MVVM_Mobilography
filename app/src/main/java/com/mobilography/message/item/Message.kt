package com.mobilography.message.item

import com.mobilography.User

data class Message(
    val user: User?,
    val text: String,
    val timestamp: String
) {
    constructor(): this(null,"","")
}