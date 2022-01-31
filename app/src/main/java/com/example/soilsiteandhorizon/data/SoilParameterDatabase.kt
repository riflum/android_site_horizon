package com.example.soilsiteandhorizon.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.soilsiteandhorizon.data.detail.SoilCodeDao
import com.example.soilsiteandhorizon.data.detail.SoilCodeEntity
import com.example.soilsiteandhorizon.data.munsell.SoilMunsellEntity

@Database(entities = [SoilParameterEntity::class,SoilCodeEntity::class,SoilMunsellEntity::class], version = 3)
abstract class SoilParameterDatabase:RoomDatabase() {
    abstract fun soilParameterDao():SoilParameterDao

    abstract fun soilCodeDao():SoilCodeDao


}