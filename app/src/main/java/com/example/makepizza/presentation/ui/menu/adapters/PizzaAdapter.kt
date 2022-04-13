package com.example.makepizza.presentation.ui.menu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.makepizza.R
import com.example.makepizza.data.model.PizzaResponse
import com.example.makepizza.databinding.PizzaItemBinding
import com.example.makepizza.presentation.utils.load

class PizzaAdapter(
    private val data: LiveData<List<PizzaResponse>>
): RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder>() {
    inner class PizzaViewHolder(view: View) : RecyclerView.ViewHolder(view)  {
        private val binding = PizzaItemBinding.bind(view)
        fun bind(item: PizzaResponse) = with(binding){
            ivPizza.load(item.imageUrl)
            tvName.text = item.name
            tvDescription.text = item.description
            btnPrice.text = binding.root.context.getString(R.string.ruble_price, item.price.toInt().toString())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaAdapter.PizzaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pizza_item, parent, false)
        return PizzaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PizzaAdapter.PizzaViewHolder, position: Int) {
        data.value?.let{
            val item = it[position]
            holder.bind(item)
        }
    }

    override fun getItemCount(): Int = data.value?.size ?: 0
}