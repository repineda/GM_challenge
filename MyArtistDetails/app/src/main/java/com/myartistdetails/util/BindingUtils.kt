package com.myartistdetails.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso


@BindingAdapter("image")
fun loadImage(view : ImageView, url : String){
    Picasso.get().load(url).into(view)
}
@BindingAdapter("price")
fun priceToString(view: TextView, double: Double)
{
    view.text = "$$double"
}
