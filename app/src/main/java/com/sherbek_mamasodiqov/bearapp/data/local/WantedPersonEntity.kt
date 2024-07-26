package com.sherbek_mamasodiqov.bearapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WantedPersonEntity(
    @PrimaryKey
    val id : Int,
    val title : String,
    val ageRange : String,
    val details : String,
    val gender : String,
    val imageUrl : String?
)
