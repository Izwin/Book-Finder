package com.izwin.bookservice.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.izwin.bookservice.R
import com.izwin.bookservice.adapters.BookAdapter
import com.izwin.bookservice.model.BookListModel
import com.izwin.bookservice.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var bookAdapter: BookAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecView()
        initEditText()
    }
    private  fun initRecView(){
        rec_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            bookAdapter = BookAdapter()
            adapter = bookAdapter
        }
    }
    private  fun initEditText(){
        editText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                loadApiData(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
    }
    fun loadApiData(input :String){


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getBookList().observe(this, Observer<BookListModel> {
            if (it != null) {
                bookAdapter.bookListData = it.items
                bookAdapter.notifyDataSetChanged()
            } else {

                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeApiCall(input)
    }
}