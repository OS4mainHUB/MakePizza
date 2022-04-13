package com.example.makepizza.presentation.ui.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.makepizza.databinding.FragmentMenuBinding
import com.example.makepizza.presentation.ui.menu.adapters.CategoriesAdapter
import com.example.makepizza.presentation.ui.menu.adapters.SalesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding
    private val viewModel: MenuViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapterSales = SalesAdapter(viewModel.salesList)
        val adapterCategory = CategoriesAdapter(viewModel.categoriesList)
        binding.recyclerSales.adapter = adapterSales
        binding.recyclerCategories.adapter = adapterCategory

        viewModel.salesList.observe(viewLifecycleOwner){
            adapterSales.notifyDataSetChanged()
        }
        viewModel.categoriesList.observe(viewLifecycleOwner){
            adapterCategory.notifyDataSetChanged()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }
}