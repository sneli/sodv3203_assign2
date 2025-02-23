package com.example.eilidh_assign2.data

import com.example.eilidh_assign2.model.ArtSpace
import com.example.eilidh_assign2.R

class Datasource {
    fun loadArtInfo(): List<ArtSpace>{
        return listOf(
            ArtSpace(R.drawable.theloveletter, R.string.love_letter, R.string.love_artist, R.string.love_year),
            ArtSpace(R.drawable.laclassededanse, R.string.dance_class, R.string.dance_artist, R.string.dance_year),
            ArtSpace(R.drawable.chrysanthemums, R.string.chrysanthemums, R.string.chrys_artist, R.string.chrys_year)
        )
    }
}