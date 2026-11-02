package com.kabi.bookpedia.book.data.network

import com.kabi.bookpedia.book.data.dto.BookWorkDto
import com.kabi.bookpedia.book.data.dto.SearchResponseDto
import com.kabi.bookpedia.core.data.safeCall
import com.kabi.bookpedia.core.domain.DataError
import com.kabi.bookpedia.core.domain.Result
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter

private const val BASE_URL = "https://openlibrary.org"

class KtorRemoteBookDataSource(
    private val httpClient: HttpClient
) : RemoteBookDataSource {

    override suspend fun searchBooks(
        query: String,
        resultLimit: Int?
    ): Result<SearchResponseDto, DataError.Remote> {
        return safeCall<SearchResponseDto> {
            httpClient.get(
                urlString = "$BASE_URL/search.json"
            ) {
                parameter("q", query)
                parameter("limit", resultLimit)
                parameter("language", "eng")
                parameter(
                    "fields",
                    "key,title,author_name,cover_i,first_publish_year,ratings_average,ratings_count,number_of_pages_median,edition_count"
                )
            }
        }
    }

    override suspend fun getBookDetails(bookWorkId: String): Result<BookWorkDto, DataError.Remote> {
        return safeCall<BookWorkDto> {
            httpClient.get(
                urlString = "$BASE_URL/works/$bookWorkId.json"
            )
        }
    }
}