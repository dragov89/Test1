package com.example.test1.domain

class EditShopItemUseCese(private val shopListRepository: ShopListRepository) {
//    fun editShopItem(name: String, count: Int) {
//    }
    fun editShopItem(shopItem: ShopItem){
        shopListRepository.editShopItem(shopItem)
    }
}