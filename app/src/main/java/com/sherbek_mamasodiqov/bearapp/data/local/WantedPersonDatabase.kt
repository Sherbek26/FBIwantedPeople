package com.sherbek_mamasodiqov.bearapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [WantedPersonEntity::class],
    version = 1
)
abstract class WantedPersonDatabase : RoomDatabase() {
    abstract val dao : WantedPersonDao
}