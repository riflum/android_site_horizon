package com.example.soilsiteandhorizon.ui.presentation

import androidx.lifecycle.ViewModel
import com.example.soilsiteandhorizon.data.detail.SoilCodeRepository
import javax.inject.Inject

class SoilCodeViewModel @Inject constructor(
    private val soilCodeRepository: SoilCodeRepository
) : ViewModel(){


//    val soilCodesById = soilCodeRepository.getSoilCodeById("Soil_Land_Form")

}