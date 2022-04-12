package com.example.makepizza.presentation.ui.menu

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.makepizza.data.model.CategoriesResponse
import com.example.makepizza.data.model.SaleResponse
import com.example.makepizza.domain.interactor.GetCategoriesUseCase
import com.example.makepizza.domain.interactor.GetSalesUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getSalesUseCase: GetSalesUseCase,
    private val getCategoriesUseCase: GetCategoriesUseCase
):  ViewModel(){
    private val _salesList = MutableLiveData<List<SaleResponse>>()
    val salesList: LiveData<List<SaleResponse>> = _salesList

    private val _categoriesList = MutableLiveData<List<CategoriesResponse>>()
    val categoriesList: LiveData<List<CategoriesResponse>> = _categoriesList

    init {
        load()
    }

    private fun load(){
        viewModelScope.launch {
            try {
                _salesList.value = getSalesUseCase.execute()
                _categoriesList.value = getCategoriesUseCase.execute()
                Log.e("TAG", _categoriesList.value.toString())
            }catch (e: Throwable){
                TODO()
            }
        }
    }

}