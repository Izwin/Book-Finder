package com.izwin.bookservice.retrofit

import com.izwin.bookservice.model.BookListModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface BookApi {
    @GET("volumes")
    fun getBookList(@Query("q") query: String) : Observable<BookListModel>
}