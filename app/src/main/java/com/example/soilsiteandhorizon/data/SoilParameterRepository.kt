package com.example.soilsiteandhorizon.data

import com.example.soilsiteandhorizon.data.detail.SoilCodeEntity
import com.example.soilsiteandhorizon.data.munsell.SoilMunsellEntity
import kotlinx.coroutines.flow.Flow

interface SoilParameterRepository {
    fun getSoilParameters():Flow<List<SoilParameterEntity>>

    suspend fun insertData(soilData:SoilParameterEntity)

    suspend fun getSoilParameterQuery(soilId:String):List<SoilParameterEntity>

    // SOIL CODE
    fun getSoilCode():Flow<List<SoilCodeEntity>>

    suspend fun getSoilCodesById(soilId:String):List<SoilCodeEntity>

    suspend fun getCodeById(id:Int):SoilCodeEntity

    suspend fun getSoilCodeQuery(soilId: String, word:String):List<SoilCodeEntity>

    /* SOIL MUNSEELL COLOR*/
    fun getSoilMunsell():Flow<List<SoilMunsellEntity>>
}