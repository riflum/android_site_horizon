package com.example.soilsiteandhorizon.data.detail

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "soil_code")
data class SoilCodeEntity (
    @PrimaryKey
    val id:Int,
    @ColumnInfo(name = "soil_parameter_id")
    val soilParameterId:String,
    @ColumnInfo(name = "comb_id")
    val combId:String,
    @ColumnInfo(name = "title")
    val title:String,
    @ColumnInfo(name = "code")
    val code:String,
    @ColumnInfo(name = "text_indonesia")
    val textIndonesia:String,
    @ColumnInfo(name = "text_english")
    val textEnglish:String
    )

