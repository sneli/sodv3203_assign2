package com.example.eilidh_assign2.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ArtSpace(
    @DrawableRes val artImageResId: Int,
    @StringRes val nameResId: Int,
    @StringRes val artistResId: Int,
    @StringRes val yearResId: Int
)
