package com.sherbek_mamasodiqov.bearapp.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.sherbek_mamasodiqov.bearapp.data.local.WantedPersonDatabase
import com.sherbek_mamasodiqov.bearapp.data.local.WantedPersonEntity
import com.sherbek_mamasodiqov.bearapp.data.remote.WantedPersonApi
import com.sherbek_mamasodiqov.bearapp.data.remote.WantedPersonRemoteMediator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@OptIn(ExperimentalPagingApi::class)
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) : WantedPersonDatabase{
        return Room.databaseBuilder(
            context,
            WantedPersonDatabase::class.java,
            "wantedPeople.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideFbiApi() : WantedPersonApi{
        return Retrofit.Builder()
            .baseUrl(WantedPersonApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WantedPersonApi::class.java)
    }

    @Provides
    @Singleton
    fun provideWantedPersonPager(database: WantedPersonDatabase,api: WantedPersonApi): Pager<Int,WantedPersonEntity>{
        return Pager(
            config = PagingConfig(pageSize = 10),
            remoteMediator = WantedPersonRemoteMediator(
                database,
                api
            ),
            pagingSourceFactory = {
                database.dao.pagingSource()
            }
        )
    }
}