package com.kabi.bookpedia.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.kabi.bookpedia.book.data.database.DatabaseFactory
import com.kabi.bookpedia.book.data.database.FavouriteBookDatabase
import com.kabi.bookpedia.book.data.network.KtorRemoteBookDataSource
import com.kabi.bookpedia.book.data.network.RemoteBookDataSource
import com.kabi.bookpedia.book.data.repository.DefaultBookRepository
import com.kabi.bookpedia.book.domain.BookRepository
import com.kabi.bookpedia.book.presentation.SelectedBookViewModel
import com.kabi.bookpedia.book.presentation.book_detail.BookDetailViewModel
import com.kabi.bookpedia.book.presentation.book_list.BookListViewModel
import com.kabi.bookpedia.core.data.HttpClientFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()
    singleOf(::DefaultBookRepository).bind<BookRepository>()

    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single { get<FavouriteBookDatabase>().favouriteBookDao }

    viewModelOf(::BookListViewModel)
    viewModelOf(::BookDetailViewModel)
    viewModelOf(::SelectedBookViewModel)
}