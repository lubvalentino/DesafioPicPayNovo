package com.example.DesafioPicPayNovo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    val userProfileAvatar: String,
    val userId: String,
    val userName: String
        ):Parcelable