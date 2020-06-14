package com.mobilography

data class User (
    val id:String,
    val email:String,
    val name:String,
    val surname:String
){
    constructor() : this("","","","")
}