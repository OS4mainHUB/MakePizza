package com.example.makepizza.presentation.ui.menu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.updateLayoutParams
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.makepizza.R
import com.example.makepizza.data.model.SaleResponse
import com.example.makepizza.databinding.SalesItemBinding
import com.example.makepizza.presentation.utils.load

class SalesAdapter(
    private val data: LiveData<List<SaleResponse>>
): RecyclerView.Adapter<SalesAdapter.SalesViewHolder>() {
    inner class SalesViewHolder(view: View) : RecyclerView.ViewHolder(view)  {
        private val binding = SalesItemBinding.bind(view)
        fun bind(item: SaleResponse) = with(binding){
            ivSales.load(item.imageUrl)
            itemView.updateLayoutParams{
                width = (itemView.resources.displayMetrics.widthPixels * 0.8).toInt()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SalesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sales_item, parent, false)
        return SalesViewHolder(view)
    }

    override fun onBindViewHolder(holder: SalesViewHolder, position: Int) {
        data.value?.let{
            val item = it[position]
            holder.bind(item)
        }
    }

    override fun getItemCount(): Int = data.value?.size ?: 0

}