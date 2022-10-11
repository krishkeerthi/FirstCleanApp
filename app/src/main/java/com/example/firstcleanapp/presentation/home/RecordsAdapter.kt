package com.example.firstcleanapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core.domain.Record
import com.example.firstcleanapp.databinding.RvCardBinding

class RecordsAdapter : RecyclerView.Adapter<RecordsViewHolder>() {
    private var records = mutableListOf<Record>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RvCardBinding.inflate(layoutInflater, parent, false)

        return RecordsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecordsViewHolder, position: Int) {
        holder.bind(records[position])
    }

    override fun getItemCount(): Int {
        return records.size
    }

    fun updateRecords(records: List<Record>){
        this.records = records.toMutableList()
        notifyDataSetChanged()
    }

    fun addRecord(record: Record){
        records.add(record)
        notifyItemInserted(records.size - 1)
    }

}

class RecordsViewHolder(val binding: RvCardBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(record: Record){
        binding.rvItemTextView.text = record.name
    }
}