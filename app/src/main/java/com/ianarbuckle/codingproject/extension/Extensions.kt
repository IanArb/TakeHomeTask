package com.ianarbuckle.codingproject.extension

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ianarbuckle.codingproject.R
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

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

fun String.resolveToDateFormat(date: String): String {
    val dateTime = DateTime(date)
    return dateTime.toString(DateTimeFormat.mediumDateTime())
}