package com.isaac.heji.adapter

import androidx.core.content.ContextCompat
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.isaac.heji.data.ItemInfo
import com.isaac.heji.R

class ItemAdapter(data: MutableList<ItemInfo>?) :
    BaseQuickAdapter<ItemInfo, BaseViewHolder>(R.layout.item_list, data) {

    private val map = arrayOf(
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

    private val itemBackground = arrayOf(
        intArrayOf(R.drawable.item_selected_red, R.drawable.item_unselected_red),
        intArrayOf(R.drawable.item_selected_blue, R.drawable.item_unselected_blue),
        intArrayOf(R.drawable.item_selected_green, R.drawable.item_unselected_green)
    )

    private val itemTextColor = arrayOf(
        R.color.item_text_red,
        R.color.item_text_blue,
        R.color.item_text_green
    )

    override fun convert(holder: BaseViewHolder, item: ItemInfo) {

        if (item.selected) {
            holder.setBackgroundRes(R.id.value, itemBackground[map[item.id] % 3][0])
            holder.setTextColor(R.id.value, ContextCompat.getColor(mContext, R.color.white))
        } else {
            holder.setBackgroundRes(R.id.value, itemBackground[map[item.id] % 3][1])
            holder.setTextColor(R.id.value, ContextCompat.getColor(mContext, itemTextColor[map[item.id] % 3]))
        }

        val value = if (item.value < 10) {
            "0" + item.value
        } else {
            "" + item.value
        }
        holder.setText(R.id.value, value)
    }
}