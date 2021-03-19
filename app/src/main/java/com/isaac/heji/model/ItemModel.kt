package com.isaac.heji.model

import com.isaac.heji.data.ItemInfo

class ItemModel {

    private val dataList = mutableListOf<ItemInfo>()
    private val style = arrayOf(
            0, 0, 1, 1, 2,
            2, 0, 0, 1, 1,
            2, 0, 0, 1, 1,
            2, 2, 0, 0, 1,
            2, 2, 0, 0, 1,
            1, 2, 2, 0, 0,
            1, 2, 2, 0, 0,
            1, 1, 2, 2, 0,
            1, 1, 2, 2, 0,
            0, 1, 1, 2
    )

    fun prepareData() {
        dataList.clear()

        for (i in 1 .. 49) {
            val itemInfo = ItemInfo(
                i,
                style[i - 1],
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