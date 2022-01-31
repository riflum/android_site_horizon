package com.example.soilsiteandhorizon.data.munsell

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "munsell_color")
data class SoilMunselEntity(
    @PrimaryKey val id:Int,
    @ColumnInfo(name = "soil_color_hue")
    val soilColorHue:String,
    @ColumnInfo(name = "soil_color_value")
    val soilColorValue:String,
    @ColumnInfo(name = "soil_color_chroma")
    val soilColorChroma:Int,
    @ColumnInfo(name = "soil_color_code")
    val soilColorCode:String,
    @ColumnInfo(name = "text_indonesia")
    val textIndonesia:String,
    @ColumnInfo(name = "text_english")
    val textEnglish:String,
    @ColumnInfo(name = "hex_color")
    val hexColor:String?
)
