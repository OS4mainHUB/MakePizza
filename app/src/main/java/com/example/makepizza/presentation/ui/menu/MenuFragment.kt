package com.example.makepizza.presentation.ui.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.makepizza.R
import com.example.makepizza.databinding.FragmentMenuBinding
import com.example.makepizza.presentation.ui.menu.adapters.CategoriesAdapter
import com.example.makepizza.presentation.ui.menu.adapters.PizzaAdapter
import com.example.makepizza.presentation.ui.menu.adapters.SalesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding
    private val viewModel: MenuViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapterSales = SalesAdapter(viewModel.salesList)
        val adapterCategory = CategoriesAdapter(viewModel.categoriesList)
        val adapterPizza = PizzaAdapter(viewModel.pizzaList)
        binding.recyclerSales.adapter = adapterSales
        binding.recyclerCategories.adapter = adapterCategory
        binding.recyclerPizza.adapter = adapterPizza

        viewModel.salesList.observe(viewLifecycleOwner){
            adapterSales.notifyDataSetChanged()
        }
        viewModel.categoriesList.observe(viewLifecycleOwner){
            adapterCategory.notifyDataSetChanged()
        }
        viewModel.pizzaList.observe(viewLifecycleOwner){
            adapterPizza.notifyDataSetChanged()
        }

        binding.swipeRefresh.setOnRefreshListener {
            viewModel.load()
        }

        binding.swipeRefresh.setColorSchemeColors(ContextCompat.getColor(requireContext(), R.color.pink))
        viewModel.action.observe(viewLifecycleOwner) { action ->
            when (action) {
                is MenuViewModel.MenuAction.HideLoader -> binding.swipeRefresh.isRefreshing =
                    false
                is MenuViewModel.MenuAction.ShowError -> Toast.makeText(
                    context,
                    action.errorMessage,
                    Toast.LENGTH_LONG
                ).show()
            }
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