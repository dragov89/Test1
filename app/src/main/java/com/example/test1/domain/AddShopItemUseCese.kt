package com.example.test1.domain

class AddShopItemUseCese(private val shopListRepository: ShopListRepository) {
    fun addShopItem(shopItem: ShopItem){
        shopListRepository.addShopItem(shopItem)

    }
}