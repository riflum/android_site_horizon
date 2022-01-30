package com.example.soilsiteandhorizon.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "soilparameter")
data class SoilParameterEntity (
    @PrimaryKey
    val id:Int,
    @ColumnInfo(name = "soil_id")
    val soilId:Int,
    @ColumnInfo(name = "sub_soil_id")
    val subSoilId:String?,
    @ColumnInfo(name = "comb_id")
    val combId:String,
    @ColumnInfo(name = "soil_parameter_id")
    val soilParameterId:String,
    @ColumnInfo(name = "title")
    val title:String,
    @ColumnInfo(name = "description")
    val description:String?
    )