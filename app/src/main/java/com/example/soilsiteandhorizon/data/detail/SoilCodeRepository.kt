package com.example.soilsiteandhorizon.data.detail

import kotlinx.coroutines.flow.Flow

interface SoilCodeRepository {
    fun getSoilCode(): Flow<List<SoilCodeEntity>>

    fun getSoilCodeById(soilId:String):Flow<List<SoilCodeEntity>>

    suspend fun insertData(soilCode: SoilCodeEntity)
}