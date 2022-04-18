package com.example.makepizza.presentation.ui.menu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.makepizza.R
import com.example.makepizza.databinding.CategoriesItemBinding
import kotlin.properties.Delegates

class CategoriesAdapter(private val onClick: (position: Int) -> Unit): RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    var data: List<String> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var selectedItem by Delegates.observable(-1) { _, old, new ->
        if (old != new) {
            data.let {
                if (new in it.indices) {
                    notifyItemChanged(old)
                    notifyItemChanged(new)
                }
            }
        }
    }

    inner class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = CategoriesItemBinding.bind(view)
        fun bind(category: String, isSelected: Boolean, position: Int) = with(binding){
            chipCategory.text = category

            chipCategory.setOnClickListener { onClick(position) }

            if (isSelected) {
                chipCategory.setTextColor(ContextCompat.getColor(itemView.context, R.color.pink))
                chipCategory.chipBackgroundColor = ContextCompat.getColorStateList(itemView.context, R.color.pink_light)
            } else {
                chipCategory.setTextColor(ContextCompat.getColor(itemView.context, R.color.gray))
                chipCategory.chipBackgroundColor = ContextCompat.getColorStateList(itemView.context, R.color.white)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesAdapter.CategoriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.categories_item, parent, false)
        return CategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesAdapter.CategoriesViewHolder, position: Int) {
        data.let{
            val item = it[position]
            holder.bind(item, position == selectedItem, position)
        }
    }

    override fun getItemCount(): Int = data.size
}