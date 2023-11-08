package com.dam.t03p02.ui.theme

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val title:Int,
    val modelVersion:Int,
    @DrawableRes val imagen:Int
) {
}