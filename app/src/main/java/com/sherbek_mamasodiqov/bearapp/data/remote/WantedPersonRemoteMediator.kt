package com.sherbek_mamasodiqov.bearapp.data.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import coil.network.HttpException
import com.sherbek_mamasodiqov.bearapp.data.local.WantedPersonDatabase
import com.sherbek_mamasodiqov.bearapp.data.local.WantedPersonEntity
import com.sherbek_mamasodiqov.bearapp.data.mappers.toWantedPersonEntity
import kotlinx.coroutines.delay
import okio.IOException

@OptIn(ExperimentalPagingApi::class)
class WantedPersonRemoteMediator(
    private val personDatabase: WantedPersonDatabase,
    private val personApi: WantedPersonApi
) : RemoteMediator<Int,WantedPersonEntity>(){
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, WantedPersonEntity>
    ): MediatorResult {
        return try {
           val loadKey = when(loadType){   //loadKey means currentPage
                LoadType.REFRESH-> 1
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null){
                        1
                    }else{
                        (lastItem.id / state.config.pageSize)+1
                    }
                }
            }
            delay(2000L)
            val wantedPeople = personApi.getWantedPeople(
                page = loadKey,
                pageSize = state.config.pageSize
            )
            personDatabase.withTransaction {
                if (loadType == LoadType.REFRESH){
                    personDatabase.dao.clearAll()
                }
                val people = wantedPeople.map { it.toWantedPersonEntity() }
                personDatabase.dao.upsertAll(people)
            }
            MediatorResult.Success(
                endOfPaginationReached = wantedPeople.isEmpty()
            )
        }catch (e : IOException){
            MediatorResult.Error(e)
        }catch (e : HttpException){
            MediatorResult.Error(e)
        }
    }

}