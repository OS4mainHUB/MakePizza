package com.example.makepizza.presentation.ui.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.makepizza.R
import com.example.makepizza.data.model.Product
import com.example.makepizza.databinding.FragmentContentBinding
import com.example.makepizza.presentation.ui.menu.adapters.MenuAdapter
import com.example.makepizza.presentation.ui.menu.adapters.VerticalItemDecoration

class ContentFragment(private val data: List<Product>) : Fragment() {

    private lateinit var binding: FragmentContentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?): Unit = with(binding)  {
        super.onViewCreated(view, savedInstanceState)
        val adapterMenu = MenuAdapter()
        recyclerContent.adapter = adapterMenu
        recyclerContent.addItemDecoration(VerticalItemDecoration(requireContext(), R.drawable.item_decoration))
        adapterMenu.data = data
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContentBinding.inflate(inflater, container, false)
        return binding.root
    }
}
