package com.example.soilsiteandhorizon.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.soilsiteandhorizon.data.detail.SoilCodeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SoilParameterDao {
    @Query("SELECT * FROM soilparameter")
    fun getSoilParameter():Flow<List<SoilParameterEntity>>

    @Query("SELECT * FROM soilparameter WHERE id = :id")
    suspend fun getSoilParameterById(id:Int):SoilParameterEntity?

    @Query("SELECT * FROM soilparameter WHERE title LIKE '%' || :word || '%'")
    suspend fun getSoilParameterQuery(word:String):List<SoilParameterEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(soilParameterEntity: SoilParameterEntity)

    @Query("DELETE FROM soilparameter")
    suspend fun deleteAllSoilParameter()

    // SOIL CODE
    @Query("SELECT * FROM soil_code")
    fun getSoilCode():Flow<List<SoilCodeEntity>>

    @Query("SELECT * FROM soil_code WHERE id = :id")
    suspend fun getSoilCodeById(id:Int):SoilCodeEntity

    @Query("SELECT * FROM soil_code WHERE soil_parameter_id = :soilId")
    suspend fun getSoilCodesById(soilId:String):List<SoilCodeEntity>

    @Query("SELECT * FROM soil_code WHERE soil_parameter_id =:soilId AND (code LIKE '%' || :word || '%' OR text_indonesia LIKE '%' || :word || '%')")
    suspend fun getSoilCodeQuery(soilId: String, word:String):List<SoilCodeEntity>
}