package com.example.makepizza.di

import com.example.makepizza.data.datasource.RemoteCategoriesDataSource
import com.example.makepizza.data.datasource.RemotePizzaDataSource
import com.example.makepizza.data.datasource.RemoteSalesDataSource
import com.example.makepizza.data.network.AppService
import com.example.makepizza.data.repository.CategoriesRepositoryImpl
import com.example.makepizza.data.repository.PizzaRepositoryImpl
import com.example.makepizza.data.repository.SalesRepositoryImpl
import com.example.makepizza.domain.interactor.GetCategoriesUseCase
import com.example.makepizza.domain.interactor.GetPizzaUseCase
import com.example.makepizza.domain.interactor.GetSalesUseCase
import com.example.makepizza.domain.repository.CategoriesRepository
import com.example.makepizza.domain.repository.PizzaRepository
import com.example.makepizza.domain.repository.SalesRepository
import com.example.makepizza.presentation.ui.menu.MenuViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import org.koin.dsl.module

val serviceModule = module {
    single<AppService> {
        Retrofit.Builder()
            .baseUrl(AppService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(AppService::class.java)
    }
}

val salesModule = module {

    single<SalesRepository> { SalesRepositoryImpl(get())}
    single { RemoteSalesDataSource(get()) }
    single { GetSalesUseCase(get()) }

}

val categoriesModule = module {

    single<CategoriesRepository> { CategoriesRepositoryImpl(get()) }
    single { RemoteCategoriesDataSource(get()) }
    single { GetCategoriesUseCase(get()) }
}

val pizzaModule = module {

    single<PizzaRepository> { PizzaRepositoryImpl(get()) }
    single { RemotePizzaDataSource(get()) }
    single { GetPizzaUseCase(get()) }
}


val viewmodelModule = module {
    viewModel { MenuViewModel(get(), get(), get()) }
}