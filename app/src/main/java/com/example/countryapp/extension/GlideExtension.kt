package com.example.countryapp.extension

import android.net.Uri
import android.widget.ImageView
import com.example.countryapp.R
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou

fun ImageView.imageLoader(url: String? = null){
    GlideToVectorYou
        .init()
        .with(context)
        .setPlaceHolder(R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground)
        .load(Uri.parse(url), this)
}