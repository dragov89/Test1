package com.example.test1.domain

class GetShopListUseCese(private val shopListRepository: ShopListRepository) {
    fun getShopList():List<ShopItem>{
        return shopListRepository.getShopList()
    }
}