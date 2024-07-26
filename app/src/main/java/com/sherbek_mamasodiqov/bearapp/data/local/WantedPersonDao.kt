package com.sherbek_mamasodiqov.bearapp.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface WantedPersonDao {
    @Upsert
    suspend fun upsertAll(people : List<WantedPersonEntity>)

    @Query("SELECT * FROM wantedpersonentity")
    fun pagingSource() : PagingSource<Int,WantedPersonEntity>

    @Query("DELETE FROM wantedpersonentity")
    suspend fun clearAll()
}