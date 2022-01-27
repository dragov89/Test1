package com.example.test1.domain

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)
    fun deleteShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun idShopItem(shopItemId: Int):ShopItem
    fun getShopList():List<ShopItem>


}