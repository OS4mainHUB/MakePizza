package com.example.makepizza.presentation.ui.menu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.makepizza.R
import com.example.makepizza.data.model.CategoriesResponse
import com.example.makepizza.databinding.CategoriesItemBinding
import kotlin.properties.Delegates

class CategoriesAdapter(
    private val data: LiveData<List<CategoriesResponse>>
): RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    private var selectedItem by Delegates.observable(-1) { _, old, new ->
        if (old != new) {
            data.value?.let {
                if (new in it.indices) {
                    notifyItemChanged(old)
                    notifyItemChanged(new)
                }
            }
        }
    }

    inner class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = CategoriesItemBinding.bind(view)
        fun bind(item: CategoriesResponse, isSelected: Boolean, position: Int) = with(binding){
            chipCategory.text = item.name

            if (position == 0) {
                chipCategory.setTextColor(ContextCompat.getColor(itemView.context, R.color.pink))
                chipCategory.chipBackgroundColor = ContextCompat.getColorStateList(itemView.context, R.color.pink_light)
            } else {
                chipCategory.isEnabled = false
            }

            //Оставил, тк если будет время, то вернусь к этому проекту и доведу до конца
            //В целом, в API добавить данные разных разделов (каталогов) не сложно
//            if (isSelected) {
//                chipCategories.setTextColor(ContextCompat.getColor(itemView.context, R.color.pink))
//                chipCategories.chipBackgroundColor = ContextCompat.getColorStateList(itemView.context, R.color.pink_light)
//            } else {
//                chipCategories.setTextColor(ContextCompat.getColor(itemView.context, R.color.button_gray_text))
//                chipCategories.chipBackgroundColor  = ContextCompat.getColorStateList(itemView.context, R.color.gray)
//            }
//
//            binding.chipCategories.setOnClickListener { selectedItem = position }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesAdapter.CategoriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.categories_item, parent, false)
        return CategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesAdapter.CategoriesViewHolder, position: Int) {
        data.value?.let{
            val item = it[position]
            holder.bind(item, position == selectedItem, position)
        }
    }

    override fun getItemCount(): Int = data.value?.size ?: 0
}