package com.yuruneji.camera_training.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

/**
 * @author toru
 * @version 1.0
 */
@Database(entities = [LogEntity::class], version = 1, exportSchema = false)
@TypeConverters(DateTimeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun logDao(): LogDao
}
