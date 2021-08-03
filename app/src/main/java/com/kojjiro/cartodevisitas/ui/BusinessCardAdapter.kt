package com.kojjiro.cartodevisitas.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kojjiro.cartodevisitas.data.BusinessCard
import com.kojjiro.cartodevisitas.databinding.ItemBusinessCardBinding

class BusinessCardAdapter :
        ListAdapter<BusinessCard, BusinessCardAdapter.ViewHolder>(DiffCallback()){

        var listenersShare:(View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBusinessCardBinding.inflate(inflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

        inner class ViewHolder(
            private val binding: ItemBusinessCardBinding
        ):RecyclerView.ViewHolder(binding.root){
            fun bind(item:BusinessCard){
                binding.tvNome.text=item.nome
                binding.tvTelefone.text=item.telefone
                binding.tvNomeEmpresa.text=item.empresa
                binding.tvEmail.text=item.email
                binding.mcvContent.setCardBackgroundColor(Color.parseColor(item.fundopersonalizado))
                binding.mcvContent.setOnClickListener {
                    listenersShare(it)
                }
            }
        }
}

class DiffCallback: DiffUtil.ItemCallback<BusinessCard>(){
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem == newItem

    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard) =
        oldItem.id == newItem.id

}