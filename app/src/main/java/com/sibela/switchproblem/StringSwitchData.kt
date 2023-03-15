package com.sibela.switchproblem

data class StringSwitchData(var id: Int, var description: String, var visible: Boolean = true) {
    companion object {
        fun getEmptyBrand() = StringSwitchData(0, "")
    }
}