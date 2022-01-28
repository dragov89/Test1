package com.example.test1.domain

data class ShopItem(
    val name:String,
    val count:Int,
    val boolean:Boolean,
    var id:Int = UNDEF_ID
){
    companion object{
        const val UNDEF_ID = -1
    }
}
