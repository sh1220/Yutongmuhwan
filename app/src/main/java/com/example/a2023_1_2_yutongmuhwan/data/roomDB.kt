package com.example.a2023_1_2_yutongmuhwan.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Food::class], version = 1)
abstract class FoodDatabase : RoomDatabase() {
    abstract fun foodDao(): FoodDao


    companion object {
        private var instance: FoodDatabase? = null

        @Synchronized
        fun getInstance(context: Context): FoodDatabase? {
            if (instance == null) {
                synchronized(FoodDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        FoodDatabase::class.java,
                        "food-database"//다른 데이터 베이스랑 이름겹치면 꼬임
                    ).fallbackToDestructiveMigration()
                        .allowMainThreadQueries().build()
                }
            }

            return instance
        }
    }
}