package com.myosetpaing.ecommercemvp.adapters

import androidx.recyclerview.widget.RecyclerView
import com.myosetpaing.ecommercemvp.views.holders.BaseViewHolder
import java.util.ArrayList

abstract class BaseRecyclerAdapter<R : BaseViewHolder<D>, D : Any> : androidx.recyclerview.widget.RecyclerView.Adapter<R>() {

    private var mDataList: MutableList<D> = ArrayList()

    override fun onBindViewHolder(viewHolder: R, position: Int) {
        viewHolder.setData(mDataList[position])
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    fun setNewData(newData: MutableList<D>) {
        mDataList = newData
        notifyDataSetChanged()
    }

    fun appendNewData(newData: List<D>) {
        mDataList!!.addAll(newData)
        notifyDataSetChanged()
    }

    fun getItemAt(position: Int): D? {
        return if (position < mDataList!!.size - 1) mDataList!![position] else null

    }

    fun removeData(data: D) {
        mDataList!!.remove(data)
        notifyDataSetChanged()
    }

    fun addNewData(data: D) {
        mDataList!!.add(data)
        notifyDataSetChanged()
    }

    fun clearData() {
        mDataList = ArrayList()
        notifyDataSetChanged()
    }
}