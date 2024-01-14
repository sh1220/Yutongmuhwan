package com.example.a2023_1_2_yutongmuhwan.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface FoodDao {
    @Insert
    fun insert(food: Food)

    @Update
    fun update(food: Food)

    @Delete
   fun delete(food: Food)

    @Query("DELETE FROM FoodTable")
    fun deleteAll()

    @Query("SELECT * FROM FoodTable") // 테이블의 모든 값을 가져와라
    fun getFoods(): List<Food>

    @Query("SELECT * FROM FoodTable WHERE id = :id")
    fun getFood(id: Int): Food

}