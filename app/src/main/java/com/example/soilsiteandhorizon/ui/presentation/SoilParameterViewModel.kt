package com.example.soilsiteandhorizon.ui.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.soilsiteandhorizon.data.SoilParameterEntity
import com.example.soilsiteandhorizon.data.SoilParameterRepository
import com.example.soilsiteandhorizon.data.detail.SoilCodeEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SoilParameterViewModel @Inject constructor(
    private val soilParameterRepository: SoilParameterRepository
) : ViewModel() {
    val soilDatas = soilParameterRepository.getSoilParameters()
    val soilCodes = soilParameterRepository.getSoilCode()

    private val _soilItems = MutableLiveData(listOf<SoilCodeEntity>())
    val soilItems: LiveData<List<SoilCodeEntity>> = _soilItems

    // Detail Screen / Code Data
    // List state value of Soil Parameter entity
    private val _soilParameterItems = MutableLiveData(listOf<SoilParameterEntity>())
    val soilParameterItems:LiveData<List<SoilParameterEntity>> = _soilParameterItems

    // Value for search query Soil List / Parameter
    private val _searchQuery =  mutableStateOf("")
    val searchQuery: State<String> = _searchQuery

    // Detail Screen / Code Data
    // List state value of Soil Code entity
    private val _soilCodeItems = MutableLiveData(listOf<SoilCodeEntity>())
    val soilCodeItems:LiveData<List<SoilCodeEntity>> = _soilCodeItems

    // Value for search query Soil Detail / Code
    private val _searchQueryCode =  mutableStateOf("")
    val searchQueryCode: State<String> = _searchQueryCode

    init {
        onSearch("")
//        onSearchCode("")
    }
//    var soilItems = mutableStateListOf<SoilCodeEntity>()
//        private set

    fun setTextFieldValue(value:String){
        _searchQuery.value = value
    }

    fun setTextFieldDetailValue(value:String){
        _searchQueryCode.value = value
    }

    // Search Function in Detail / Code Screen
    fun onSearchCode(soilId: String, query:String){
        _searchQueryCode.value = query
        viewModelScope.launch {
            _soilCodeItems.value = soilParameterRepository.getSoilCodeQuery(soilId, query)
        }
    }

    // Search Function in Master / Parameter Screen
    fun onSearch(query: String){
        _searchQuery.value = query
        viewModelScope.launch {
            _soilParameterItems.value = soilParameterRepository.getSoilParameterQuery(query)
        }
    }

    fun getSoilId(soilId:String){

        viewModelScope.launch {
            _soilItems.value = soilParameterRepository.getSoilCodesById(soilId)
//            soilParameterRepository.getSoilCodesById(soilId).forEach {
//                soilItems.add(it)
//            }
        }
    }
//    fun getSoilId(soilId:Int){
//        viewModelScope.launch {
//            soilData1 = soilParameterRepository.getCodeById(soilId)
//        }
//    }



}