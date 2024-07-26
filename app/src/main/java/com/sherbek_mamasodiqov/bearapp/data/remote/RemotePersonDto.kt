package com.sherbek_mamasodiqov.bearapp.data.remote

data class RemotePersonDto(
    val id : Int,
    val title : String,
    val ageRange : String,
    val details : String,
    val gender : String,
    val imageUrl : String?
)
