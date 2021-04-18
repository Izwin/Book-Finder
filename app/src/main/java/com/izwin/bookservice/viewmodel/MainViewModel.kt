package com.izwin.bookservice.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.izwin.bookservice.model.BookListModel
import com.izwin.bookservice.retrofit.BookApi
import com.izwin.bookservice.retrofit.RetroInstance
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit


class MainViewModel : ViewModel() {
    lateinit var booklist : MutableLiveData<BookListModel>
    init{
        booklist = MutableLiveData()
    }

    fun getBookList(): MutableLiveData<BookListModel> {
        return booklist
    }
    fun makeApiCall(query: String){
        RetroInstance.getRetrofitInstance()
            .create(BookApi::class.java)
            .getBookList(query)
            .delay(1000, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getBookListObserver())

    }
    private fun getBookListObserver():Observer<BookListModel>{
        return object : Observer<BookListModel> {
            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: BookListModel) {
               booklist.postValue(t)
            }

            override fun onError(e: Throwable) {
                booklist.postValue(null)
            }

            override fun onComplete() {

            }


        }
    }

}


