package com.kabi.bookpedia.book.presentation.book_detail

import com.kabi.bookpedia.book.domain.Book

sealed interface BookDetailAction {
    data object OnBackClick: BookDetailAction
    data object OnFavouriteClick: BookDetailAction
    data class OnSelectedBookChange(val book: Book): BookDetailAction
}