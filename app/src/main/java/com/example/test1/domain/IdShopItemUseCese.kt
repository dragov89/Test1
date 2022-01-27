package com.example.test1.domain

class IdShopItemUseCese(private val shopListRepository: ShopListRepository) {
    fun idShopItem(shopItemId: Int):ShopItem{
       return shopListRepository.idShopItem(shopItemId)
    }
}