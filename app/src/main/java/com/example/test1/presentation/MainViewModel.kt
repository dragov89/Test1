package com.example.test1.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test1.data.ShopListRepositoryImpl
import com.example.test1.domain.DeleteShopItemUseCese
import com.example.test1.domain.EditShopItemUseCese
import com.example.test1.domain.GetShopListUseCese
import com.example.test1.domain.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl
    val getShopListUseCase = GetShopListUseCese(repository)
    val deleteShopItemUseCase = DeleteShopItemUseCese(repository)
    val editShopItemUseCase = EditShopItemUseCese(repository)

     val shopList = getShopListUseCase.getShopList()

     fun deleteShopItem(shopItem: ShopItem){
         deleteShopItemUseCase.deleteShopItem(shopItem)

    }
     fun editEnabletState(shopItem: ShopItem){
         val newItem = shopItem.copy(boolean = !shopItem.boolean)
         editShopItemUseCase.editShopItem(newItem)
    }
}