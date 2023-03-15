package com.sibela.switchproblem

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sibela.switchproblem.databinding.ItemStringSwitcherBinding

class StringSwitchAdapter(
    private val brandSwitchedListener: (StringSwitchData, Boolean) -> Unit,
) : ListAdapter<StringSwitchData, StringSwitchAdapter.BrandViewHolder>(StringSwitchDataDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringSwitchAdapter.BrandViewHolder {
        return getBrandViewHolderFrom(parent)
    }

    override fun onBindViewHolder(holder: StringSwitchAdapter.BrandViewHolder, position: Int) {
            holder.bind(getItem(position), brandSwitchedListener)
    }

    private fun getBrandViewHolderFrom(parent: ViewGroup): BrandViewHolder = BrandViewHolder(
        ItemStringSwitcherBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    inner class BrandViewHolder(private val binding: ItemStringSwitcherBinding) :
        ViewHolder(binding.root) {

        fun bind(
            brand: StringSwitchData,
            brandSwitchedListener: (StringSwitchData, Boolean) -> Unit,
        ) = binding.run {
            stringSwitcher.text = brand.description
            stringSwitcher.isChecked = brand.visible
            stringSwitcher.setOnCheckedChangeListener { _, isChecked ->
                brandSwitchedListener.invoke(brand, isChecked)
                currentList.indexOf(brand).also { index ->
                    currentList[index].visible = isChecked
                }
            }
        }
    }
}