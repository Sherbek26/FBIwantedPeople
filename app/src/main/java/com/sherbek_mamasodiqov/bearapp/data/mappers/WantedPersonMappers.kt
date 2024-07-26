package com.sherbek_mamasodiqov.bearapp.data.mappers

import com.sherbek_mamasodiqov.bearapp.data.local.WantedPersonEntity
import com.sherbek_mamasodiqov.bearapp.data.remote.RemotePersonDto
import com.sherbek_mamasodiqov.bearapp.domain.WantedPerson

fun RemotePersonDto.toWantedPersonEntity() : WantedPersonEntity{
    return WantedPersonEntity(
        id = id,
        title = title,
        ageRange = ageRange,
        details = details,
        gender = gender,
        imageUrl = imageUrl
    )
}

fun WantedPersonEntity.toWantedPerson() : WantedPerson {
    return WantedPerson(
        id = id,
        title = title,
        ageRange = ageRange,
        details = details,
        gender = gender,
        imageUrl = imageUrl
    )
}