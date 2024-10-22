package com.sample.loadingindicator

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.loadingindicator.databinding.ItemIndicatorBinding

class IndicatorAdapter(private var context: Context, private var indicators: ArrayList<String>) :
    RecyclerView.Adapter<IndicatorAdapter.IndicatorHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IndicatorHolder {
        return IndicatorHolder(
            ItemIndicatorBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount() = indicators.size

    override fun onBindViewHolder(holder: IndicatorHolder, position: Int) {
        holder.binding.indicator.setIndicator(indicators[position])
        holder.itemView.setOnClickListener {
            IndicatorActivity.launchActivity(context, indicators[position])
        }
    }

    class IndicatorHolder(var binding: ItemIndicatorBinding) : RecyclerView.ViewHolder(binding.root)
}