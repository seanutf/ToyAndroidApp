package com.seanutf.learn.toyandroid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.seanutf.learn.toyandroid.common.extention.setNoDoubleClickListener
import com.seanutf.learn.toyandroid.databinding.ItemHomeListBinding

internal class MainListAdapter(
    private val onClickItem:(position: Int) -> Unit,
): RecyclerView.Adapter<MainListViewHolder>() {

    private var dataList: MutableList<String>? = null
    internal fun updateList(list: MutableList<String>?){
        this.dataList = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListViewHolder {
        return MainListViewHolder.create(parent)

    }

    override fun onBindViewHolder(holder: MainListViewHolder, position: Int) {
        val data = dataList?.get(position)
        data?.let {
            holder.bindData(it)
            holder.itemView.setNoDoubleClickListener {
                onClickItem(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataList?.size ?: 0
    }
}

internal class MainListViewHolder(
    private val itemBinding: ItemHomeListBinding,
): RecyclerView.ViewHolder(itemBinding.root) {

    fun bindData(title: String) {
        itemBinding.tvTitle.text = title
    }

    companion object{
        fun create(parent: ViewGroup): MainListViewHolder{
            val itemBinding = ItemHomeListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return MainListViewHolder(itemBinding)
        }
    }
}