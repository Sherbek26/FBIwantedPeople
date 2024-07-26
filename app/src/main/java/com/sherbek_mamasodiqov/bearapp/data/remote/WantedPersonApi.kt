package com.sherbek_mamasodiqov.bearapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface WantedPersonApi {
    @GET("wanted/v1/list")
    suspend fun getWantedPeople(
        @Query("page") page : Int,
        @Query("pageSize") pageSize : Int
    ) : List<RemotePersonDto>

    companion object{
        const val BASE_URL = "https://api.fbi.gov/"
    }
}