package com.example.soilsiteandhorizon.data.detail

import kotlinx.coroutines.flow.Flow

class SoilCodeRepositoryImpl(
    private val soilCodeDao:SoilCodeDao
):SoilCodeRepository {
    override fun getSoilCode(): Flow<List<SoilCodeEntity>> {
        return soilCodeDao.getSoilCodes()
    }

    override fun getSoilCodeById(soilId: String): Flow<List<SoilCodeEntity>> {
        return soilCodeDao.getSoilCodeById(soilId)
    }

    override suspend fun insertData(soilCode: SoilCodeEntity) {

    }
}