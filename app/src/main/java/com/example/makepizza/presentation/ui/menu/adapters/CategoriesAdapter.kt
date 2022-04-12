package com.example.makepizza.presentation.ui.menu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.makepizza.R
import com.example.makepizza.data.model.CategoriesResponse
import com.example.makepizza.databinding.CategoriesItemBinding

class CategoriesAdapter(
    private val data: LiveData<List<CategoriesResponse>>
): RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {
    inner class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = CategoriesItemBinding.bind(view)
        fun bind(item: CategoriesResponse) = with(binding){
            chipCategories.text = item.name
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesAdapter.CategoriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.categories_item, parent, false)
        return CategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesAdapter.CategoriesViewHolder, position: Int) {
        data.value?.let{
            val item = it[position]
            holder.bind(item)
        }
    }

    override fun getItemCount(): Int = data.value?.size ?: 0
}