package com.example.a2023_1_2_yutongmuhwan

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a2023_1_2_yutongmuhwan.data.Food
import com.example.a2023_1_2_yutongmuhwan.databinding.ItemListBinding

class ListAdapter (private val foodList: ArrayList<Food>): RecyclerView.Adapter<ListAdapter.Viewholder>()  {



    interface OnImgClickListener {
        fun onImgClickListener()
    }

    private lateinit var imgClickListener: ListAdapter.OnImgClickListener

    fun setOnImgClickListener(onImgClickListener: ListAdapter.OnImgClickListener) {
        imgClickListener = onImgClickListener
    }

    inner class Viewholder(val binding: ItemListBinding) :RecyclerView.ViewHolder(binding.root){
        fun bind(foodInfo:Food){
            binding.foodNameTv.text = foodInfo.name
            binding.foodPurchaseDateTv.text = foodInfo.purchase_data_month.toString() + '/' + foodInfo.purchase_data_day.toString()
            binding.foodExpirationDateTv.text = foodInfo.expiration_data_month.toString() + '/' + foodInfo.expiration_data_day.toString()

            binding.foodPurchaseButtonTv.setOnClickListener {
                imgClickListener.onImgClickListener()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Viewholder(binding)
    }

    override fun getItemCount(): Int = foodList.size

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.bind(foodList[position])
    }



}