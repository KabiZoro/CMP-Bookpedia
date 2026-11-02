package com.kabi.bookpedia.book.data.network

import com.kabi.bookpedia.book.data.dto.BookWorkDto
import com.kabi.bookpedia.book.data.dto.SearchResponseDto
import com.kabi.bookpedia.core.domain.DataError
import com.kabi.bookpedia.core.domain.Result

interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDto, DataError.Remote>

    suspend fun getBookDetails(bookWorkId: String): Result<BookWorkDto, DataError.Remote>
}