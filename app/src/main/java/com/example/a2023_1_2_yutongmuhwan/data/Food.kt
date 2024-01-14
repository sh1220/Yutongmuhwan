package com.example.a2023_1_2_yutongmuhwan.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "FoodTable")
data class Food(
    var name: String,
    var purchase_data_month : Int,
    var purchase_data_day : Int,
    var expiration_data_month : Int,
    var expiration_data_day : Int
){
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}

