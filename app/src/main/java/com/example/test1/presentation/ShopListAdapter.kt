package com.example.test1.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.test1.R
import com.example.test1.domain.ShopItem

class ShopListAdapter :
    androidx.recyclerview.widget.ListAdapter<ShopItem, ShopItemViewHolder>(
        ShopItemDiffCallback()
    ) {

    var onShopOnClicLongListener: ((ShopItem) -> Unit)? = null
    var onShopOnClicListener: ((ShopItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val layout = when (viewType) {
            ENABLED -> R.layout.item_shop_enabled
            DISABLED -> R.layout.item_shop_disabled
            else -> throw RuntimeException("viewType $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ShopItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        val shopItem = getItem(position)
        holder.view.setOnLongClickListener {
            onShopOnClicLongListener?.invoke(shopItem)
            true
        }
        holder.view.setOnClickListener {
            onShopOnClicListener?.invoke(shopItem)
        }
        holder.tvName.text = shopItem.name
        holder.tvCount.text = shopItem.count.toString()
    }

    override fun getItemViewType(position: Int): Int {
        val itemPos = getItem(position)
        return if (itemPos.boolean) {
            ENABLED
        } else {
            DISABLED
        }
    }

    companion object {
        const val ENABLED = 103
        const val DISABLED = 301

        const val MAX_POOL_SIZE = 10
    }
}
