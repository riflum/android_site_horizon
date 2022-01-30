package com.example.soilsiteandhorizon.data.detail

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SoilCodeDao {
    @Query("SELECT * FROM soil_code")
    fun getSoilCodes(): Flow<List<SoilCodeEntity>>

    @Query("SELECT * FROM soil_code WHERE soil_parameter_id = :soilId")
    fun getSoilCodeById(soilId:String): Flow<List<SoilCodeEntity>>

    @Query("SELECT * FROM soil_code WHERE title LIKE '%' || :word || '%'")
    suspend fun getSoilCodeQuery(word:String):List<SoilCodeEntity>
}