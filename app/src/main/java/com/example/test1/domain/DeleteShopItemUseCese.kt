package com.example.test1.domain

class DeleteShopItemUseCese(private val shopListRepository: ShopListRepository) {
 fun deleteShopItem(shopItem: ShopItem){
  shopListRepository.deleteShopItem(shopItem)

 }
}