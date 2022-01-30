package com.example.soilsiteandhorizon.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.soilsiteandhorizon.data.detail.SoilCodeDao
import com.example.soilsiteandhorizon.data.detail.SoilCodeEntity

@Database(entities = [SoilParameterEntity::class,SoilCodeEntity::class], version = 2)
abstract class SoilParameterDatabase:RoomDatabase() {
    abstract fun soilParameterDao():SoilParameterDao

    abstract fun soilCodeDao():SoilCodeDao

}