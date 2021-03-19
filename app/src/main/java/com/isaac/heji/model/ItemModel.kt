package com.isaac.heji.model

import com.isaac.heji.data.ItemInfo

class ItemModel {

    private val dataList = mutableListOf<ItemInfo>()

    fun prepareData() {
        dataList.clear()

        for (i in 1 .. 49) {
            val itemInfo = ItemInfo(
                i - 1,
                i,
                false
            )
            dataList.add(itemInfo)
        }
    }

    fun changeSelected(position: Int) {
        if (dataList.size <= position) return

        dataList[position].selected = !dataList[position].selected
    }

    fun getList() = dataList
}