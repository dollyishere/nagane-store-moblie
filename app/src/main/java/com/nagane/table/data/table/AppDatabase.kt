package com.nagane.table.data.table

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nagane.table.data.dao.BasketDao
import com.nagane.table.data.dao.StoreTableDao
import com.nagane.table.data.entity.BasketEntity
import com.nagane.table.data.entity.StoreTableEntity

@Database(entities = [StoreTableEntity::class, BasketEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun storeTableDao(): StoreTableDao
    abstract fun basketDao() : BasketDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "store_table_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}