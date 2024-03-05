package com.example.recyclerviewexercise

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerviewexercise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val list = mutableListOf(
        "Word 1",
        "Word 2",
        "Word 3",
        "Word 4",
        "Word 5",
        "Word 6",
        "Word 7",
        "Word 8",
        "Word 9",
        "Word 10",
        "Word 11",
        "Word 12",
        "Word 13",
        "Word 14",
        "Word 15",
        "Word 16",
        "Word 17",
        "Word 18",
        "Word 19",
        "Word 20",
        "Word 21",
        "Word 22",
        "Word 23",
        "Word 24",
    )
    private lateinit var adapter : ExerciseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        adapter = ExerciseAdapter(this)
        binding.listItem.adapter = adapter
        adapter.setListData(list)

        binding.btnAdd.setOnClickListener {
            list.add("+ Word " + "${list.size +1}")
            adapter = ExerciseAdapter(this)
            binding.listItem.adapter = adapter
            adapter.setListData(list)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onItemClickListener(position: Int) {
        if (list[position].contains("Clicked")){
            list[position] = list[position].removePrefix("Clicked! ")
        } else {
            list[position] = "Clicked! " + list[position]
        }
        adapter = ExerciseAdapter(this)
        binding.listItem.adapter = adapter
        adapter.setListData(list)
    }

}