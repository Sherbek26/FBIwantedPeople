package com.sherbek_mamasodiqov.bearapp.domain

data class WantedPerson(
    val id : Int,
    val title : String,
    val ageRange : String,
    val details : String,
    val gender : String,
    val imageUrl : String?
)
