package com.example.recyclerviewexercise

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexercise.databinding.ItemListBinding

class ExerciseAdapter(var listener: OnItemClickListener): RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder>(){

    private val listData = mutableListOf<String>()

    inner class ExerciseViewHolder(private val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root), View.OnClickListener{
        fun bindData(newItem: String){
            binding.item.text = newItem
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION)
            {
                listener.onItemClickListener(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ExerciseViewHolder(ItemListBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        holder.bindData(listData[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setListData(listData: List<String>){
        this.listData.clear()
        this.listData.addAll(listData)
        notifyDataSetChanged()
    }

}

