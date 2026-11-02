package com.kabi.bookpedia.book.presentation.book_list

import com.kabi.bookpedia.book.domain.Book

sealed interface BookListAction {
    data class OnSearchQueryChange(val query: String): BookListAction
    data class OnBookClick(val book: Book): BookListAction
    data class OnTapSelected(val index: Int): BookListAction
}