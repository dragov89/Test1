package com.example.test1.domain

import androidx.lifecycle.LiveData

class GetShopListUseCese(private val shopListRepository: ShopListRepository) {
    fun getShopList():LiveData<List<ShopItem>>{
        return shopListRepository.getShopList()
    }
}