package com.example.makepizza.di

import com.example.makepizza.data.datasource.RemoteContentCategoriesDataSource
import com.example.makepizza.data.datasource.RemoteSalesDataSource
import com.example.makepizza.data.network.AppService
import com.example.makepizza.data.repository.ContentCategoriesRepositoryImpl
import com.example.makepizza.data.repository.SalesRepositoryImpl
import com.example.makepizza.domain.interactor.GetContentCategoriesUseCase
import com.example.makepizza.domain.interactor.GetSalesUseCase
import com.example.makepizza.domain.repository.ContentCategoriesRepository
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


val pizzaModule = module {
    single<ContentCategoriesRepository> { ContentCategoriesRepositoryImpl(get()) }
    single { RemoteContentCategoriesDataSource(get()) }
    single { GetContentCategoriesUseCase(get()) }
}

val viewmodelModule = module {
    viewModel { MenuViewModel(get(), get()) }
}