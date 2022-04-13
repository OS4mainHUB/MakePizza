package com.example.makepizza.presentation.ui.menu

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.makepizza.data.model.CategoriesResponse
import com.example.makepizza.data.model.PizzaResponse
import com.example.makepizza.data.model.SaleResponse
import com.example.makepizza.domain.interactor.GetCategoriesUseCase
import com.example.makepizza.domain.interactor.GetPizzaUseCase
import com.example.makepizza.domain.interactor.GetSalesUseCase
import kotlinx.coroutines.launch

class MenuViewModel(
    private val getSalesUseCase: GetSalesUseCase,
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getPizzaUseCase: GetPizzaUseCase
):  ViewModel(){
    private val _salesList = MutableLiveData<List<SaleResponse>>()
    val salesList: LiveData<List<SaleResponse>> = _salesList

    private val _categoriesList = MutableLiveData<List<CategoriesResponse>>()
    val categoriesList: LiveData<List<CategoriesResponse>> = _categoriesList

    private val _pizzaList = MutableLiveData<List<PizzaResponse>>()
    val pizzaList: LiveData<List<PizzaResponse>> = _pizzaList

    init {
        load()
    }

    private fun load(){
        viewModelScope.launch {
            try {
                _salesList.value = getSalesUseCase.execute()
                _categoriesList.value = getCategoriesUseCase.execute()
                _pizzaList.value = getPizzaUseCase.execute()
                Log.e("TAG", _pizzaList.value.toString())
            }catch (e: Throwable){
                TODO()
            }
        }
    }

}