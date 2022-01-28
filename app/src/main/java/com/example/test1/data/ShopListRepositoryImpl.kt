package com.example.test1.data

import com.example.test1.domain.ShopItem
import com.example.test1.domain.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {

    private var defId = 0

    private val shopList = mutableListOf<ShopItem>()

    init {
        for (i in 0 until 10){
            val item = ShopItem("name $i", i, true)
            addShopItem(item)
        }
    }

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEF_ID) {
            shopItem.id = defId++
        }
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldShopItem = idShopItem(shopItem.id)
        shopList.remove(oldShopItem)
        addShopItem(shopItem)
    }

    override fun idShopItem(shopItemId: Int): ShopItem {
        return shopList.find { it.id == shopItemId }
            ?: throw RuntimeException("Id $shopItemId not found")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }
}