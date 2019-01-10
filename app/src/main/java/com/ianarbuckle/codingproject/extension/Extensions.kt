package com.ianarbuckle.codingproject.extension

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ianarbuckle.codingproject.R

/**
 * Created by Ian Arbuckle on 18/11/2018.
 *
 */
fun ImageView.provideImage(context: Context, imageUrl: String) {
    val requestOptions = RequestOptions()
    Glide.with(context)
            .load(imageUrl)
            .apply(requestOptions)
            .into(this)
}

@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(imageUrl: String) = provideImage(context, imageUrl)

@BindingAdapter("statusColor")
fun TextView.setStatusColor(status: String) {
    when(status) {
        "OPEN" -> setTextColor(ContextCompat.getColor(context, R.color.colorGreen))
        "CLOSED" -> setTextColor(ContextCompat.getColor(context, R.color.colorRed))
    }
}