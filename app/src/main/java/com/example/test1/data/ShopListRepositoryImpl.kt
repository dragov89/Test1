package com.example.test1.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.test1.domain.ShopItem
import com.example.test1.domain.ShopListRepository
import kotlin.random.Random

object ShopListRepositoryImpl : ShopListRepository {

    private var defId = 0
private val shopListLD = MutableLiveData<List<ShopItem>>()
//    private val shopList = sortedSetOf<ShopItem>(object :Comparator<ShopItem>{
//        override fun compare(p0: ShopItem?, p1: ShopItem?): Int {
//        }
//    })

    private val shopList = sortedSetOf<ShopItem>({ p0, p1 -> p0.id.compareTo(p1.id) })

    init {
        for (i in 0 until 1000){
            val item = ShopItem("Name $i", Random.nextInt(1, 5), Random.nextBoolean())
            addShopItem(item)
        }
    }

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEF_ID) {
            shopItem.id = defId++
        }
        shopList.add(shopItem)
        updateList()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
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

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }
    fun updateList(){
        shopListLD.value = shopList.toList()
    }
}