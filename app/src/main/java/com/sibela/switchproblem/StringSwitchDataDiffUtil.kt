package com.sibela.switchproblem

import androidx.recyclerview.widget.DiffUtil

class StringSwitchDataDiffUtil : DiffUtil.ItemCallback<StringSwitchData>() {

    override fun areItemsTheSame(oldItem: StringSwitchData, newItem: StringSwitchData) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: StringSwitchData, newItem: StringSwitchData) =
        oldItem.description == newItem.description && oldItem.visible == newItem.visible
}