package com.example.soilsiteandhorizon.di

import android.app.Application
import androidx.room.Room
import com.example.soilsiteandhorizon.data.SoilParameterDatabase
import com.example.soilsiteandhorizon.data.SoilParameterRepository
import com.example.soilsiteandhorizon.data.SoilParameterRepositoryImpl
import com.example.soilsiteandhorizon.data.detail.SoilCodeRepository
import com.example.soilsiteandhorizon.data.detail.SoilCodeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesSoilDatabase(app:Application):SoilParameterDatabase{
        return Room.databaseBuilder(
            app,
            SoilParameterDatabase::class.java,
            "soil_database"
        )
            .fallbackToDestructiveMigration()
            .createFromAsset("database/SoilParameter3.db")
            .build()
    }

    @Provides
    @Singleton
    fun providesSoilRepository(db:SoilParameterDatabase): SoilParameterRepository {
        return SoilParameterRepositoryImpl(db.soilParameterDao())
    }

    @Provides
    @Singleton
    fun providesSoilCodeRepository(db:SoilParameterDatabase): SoilCodeRepository {
        return SoilCodeRepositoryImpl(db.soilCodeDao())
    }
}