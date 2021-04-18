package com.izwin.bookservice.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.izwin.bookservice.R
import com.izwin.bookservice.model.BookInfo
import com.izwin.bookservice.model.BookListModel
import com.izwin.bookservice.model.BookVolumeInfo
import kotlinx.android.synthetic.main.book_item.view.*

class BookAdapter : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    var bookListData = ArrayList<BookVolumeInfo>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
        return BookViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val volumeInfo = bookListData[position]
        if (volumeInfo!=null) {
            holder.title.text = volumeInfo.volumeInfo.title
            holder.desc.text = volumeInfo.volumeInfo.description
            holder.page.text = volumeInfo.volumeInfo.pageCount
            holder.publisher.text = volumeInfo.volumeInfo.publisher
            holder.year.text = volumeInfo.volumeInfo.publishedDate
            Glide.with(holder.img)
                .load(volumeInfo.volumeInfo.imageLinks?.smallThumbnail)
                .into(holder.img)
        }
    }

    override fun getItemCount(): Int {
        return bookListData.size
    }

    class BookViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val img = view.img_view
        val title = view.book_title
        var publisher = view.book_publisher
        val year = view.book_year
        val desc = view.book_desc
        val page = view.book_page_count


    }
}