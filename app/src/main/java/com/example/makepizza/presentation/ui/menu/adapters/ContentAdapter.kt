package com.example.makepizza.presentation.ui.menu.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.makepizza.data.model.ContentCategoriesResponse
import com.example.makepizza.presentation.ui.menu.ContentFragment

class ContentAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    var collection: List<ContentCategoriesResponse> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = collection.size

    override fun createFragment(position: Int): Fragment = ContentFragment(collection[position].items)

}