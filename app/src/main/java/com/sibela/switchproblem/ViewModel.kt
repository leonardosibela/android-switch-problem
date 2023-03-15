package com.sibela.switchproblem

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ViewModel : androidx.lifecycle.ViewModel() {

    private val _brandsFlow = MutableStateFlow<List<StringSwitchData>?>(null)
    val brandsFlow = _brandsFlow.asStateFlow()

    fun initialize() = viewModelScope.launch {
        _brandsFlow.value = getAll()
    }

    private fun getAll(): List<StringSwitchData> {
        val strings = ArrayList<StringSwitchData>()
        for (i in 1..30) {
            strings.add(StringSwitchData(i, "Some string $i", false))
        }
        return strings
    }

    fun updateBrand(stringSwitchData: StringSwitchData, visible: Boolean) = viewModelScope.launch {
        stringSwitchData.apply { this.visible = visible }
        updateBrand(stringSwitchData)
    }

    private fun updateBrand(stringSwitchData: StringSwitchData) {

    }
}