package com.isaac.heji

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.isaac.heji.adapter.ItemAdapter
import com.isaac.heji.data.ItemInfo
import com.isaac.heji.model.ItemModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var adapter: ItemAdapter? = null

    private val itemModel = ItemModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_list.layoutManager = GridLayoutManager(this, 5)
        adapter = ItemAdapter(itemModel.getList())
        adapter?.bindToRecyclerView(rv_list)
        adapter?.setOnItemClickListener { _, _, position ->
            itemModel.changeSelected(position)
            adapter?.notifyItemChanged(position)
        }
    }

    override fun onResume() {
        super.onResume()

        itemModel.prepareData()
        adapter?.notifyDataSetChanged()
    }
}