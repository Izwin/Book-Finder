package com.izwin.bookservice.model


public class BookListModel(val items: ArrayList<BookVolumeInfo>)
public class BookVolumeInfo(val volumeInfo: BookInfo)
public class BookInfo(val title:String , val publishedDate: String, val description: String , val publisher: String , val pageCount: String , val imageLinks: ImageLink)
public class ImageLink(val smallThumbnail: String)
