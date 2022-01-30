package com.example.soilsiteandhorizon.data

import com.example.soilsiteandhorizon.data.detail.SoilCodeEntity
import kotlinx.coroutines.flow.Flow

class SoilParameterRepositoryImpl(
    private val soilParameterDao: SoilParameterDao
):SoilParameterRepository {

    override fun getSoilParameters(): Flow<List<SoilParameterEntity>> {
        return soilParameterDao.getSoilParameter()
    }

    override suspend fun insertData(soilData: SoilParameterEntity) {
        soilParameterDao.insert(soilData)
    }

    override fun getSoilCode(): Flow<List<SoilCodeEntity>> {
        return soilParameterDao.getSoilCode()
    }

    override suspend fun getSoilParameterQuery(soilId: String): List<SoilParameterEntity> {
        return soilParameterDao.getSoilParameterQuery(soilId)
    }

    override suspend fun getSoilCodesById(soilId: String): List<SoilCodeEntity> {
        return soilParameterDao.getSoilCodesById(soilId)
    }

    override suspend fun getCodeById(id: Int): SoilCodeEntity {
        return soilParameterDao.getSoilCodeById(id)
    }

    override suspend fun getSoilCodeQuery(soilId: String, word: String): List<SoilCodeEntity> {
        return soilParameterDao.getSoilCodeQuery(soilId, word)
    }
}