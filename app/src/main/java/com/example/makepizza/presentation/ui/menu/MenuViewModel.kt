package com.example.makepizza.presentation.ui.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.makepizza.data.model.*
import com.example.makepizza.domain.interactor.GetContentCategoriesUseCase
import com.example.makepizza.domain.interactor.GetSalesUseCase
import kotlinx.coroutines.launch

class MenuViewModel(
    private val getSalesUseCase: GetSalesUseCase,
    private val getContentCategoriesUseCase: GetContentCategoriesUseCase
):  ViewModel(){
    private val _salesList = MutableLiveData<List<SaleResponse>>()
    val salesList: LiveData<List<SaleResponse>> = _salesList

    private val _content = MutableLiveData<List<ContentCategoriesResponse>>()
    val content: LiveData<List<ContentCategoriesResponse>> = _content


//    private var titleCategoriesList: List<String>? = emptyList()


    private val _action = MutableLiveData<MenuAction>()
    val action: LiveData<MenuAction> = _action

    init {
        load()
    }

    fun load(){
        viewModelScope.launch {
            try {
                _salesList.postValue(getSalesUseCase.execute())
                _content.postValue(getContentCategoriesUseCase.execute())
            }catch (e: Throwable){
                _action.value = MenuAction.ShowError("Нестабильное соединение")
            }
            _action.value = MenuAction.HideLoader
        }
    }

    sealed class MenuAction {
        object HideLoader : MenuAction()
        data class ShowError(val errorMessage: String): MenuAction()
    }
}