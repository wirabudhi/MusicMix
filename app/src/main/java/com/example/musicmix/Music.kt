package com.example.musicmix

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Music(
    val title: String,
    val years: String,
    val musician: String,
    val photo: Int,
    val album: String,
    val genre: String,
    val duration: String,
    val lyrics: String
) : Parcelable
