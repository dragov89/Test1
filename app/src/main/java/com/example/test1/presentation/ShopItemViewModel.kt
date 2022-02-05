package com.example.test1.presentation

import androidx.lifecycle.ViewModel
import com.example.test1.data.ShopListRepositoryImpl
import com.example.test1.domain.AddShopItemUseCese
import com.example.test1.domain.EditShopItemUseCese
import com.example.test1.domain.IdShopItemUseCese
import com.example.test1.domain.ShopItem

class ShopItemViewModel() : ViewModel() {
    private val repository = ShopListRepositoryImpl
    private val idShopItemUseCese = IdShopItemUseCese(repository)
    private val addShopItemUseCese = AddShopItemUseCese(repository)
    private val editSgopItemUseCese = EditShopItemUseCese(repository)


    fun idShopItem(shopItemId: Int) {
        val item = idShopItemUseCese.idShopItem(shopItemId)
    }

    fun addShopItem(imputName: String?, imputCount: String?) {
        val name = parsName(imputName)
        val count = parsCount(imputCount)
        val fildsValide = validateInput(name, count)
        if (fildsValide) {
            val shopItem = ShopItem(name, count, true)
            addShopItemUseCese.addShopItem(shopItem)
        }
    }

    fun editShopItem(imputName: String?, imputCount: String?) {
        val name = parsName(imputName)
        val count = parsCount(imputCount)
        val fildsValide = validateInput(name, count)
        if (fildsValide) {
            val shopItem = ShopItem(name, count, false)
            editSgopItemUseCese.editShopItem(shopItem)
        }
    }

    private fun parsName(imputName: String?): String {
        return imputName?.trim() ?: ""
    }

    private fun parsCount(imputCount: String?): Int {
        return try {
            imputCount?.trim()?.toInt() ?: 0
        } catch (e: Exception) {
            0
        }
    }

    private fun validateInput(name: String, count: Int): Boolean {
        var result = true
        if (name.isBlank()) {
            //TODO: ERROR
            result = false
        }
        if (count <= 0) {
            //TODO: ERROR
            result = false
        }
        return result
    }

}