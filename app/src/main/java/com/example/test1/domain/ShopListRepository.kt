package com.example.test1.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)
    fun deleteShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun idShopItem(shopItemId: Int):ShopItem
    fun getShopList():LiveData<List<ShopItem>>


}