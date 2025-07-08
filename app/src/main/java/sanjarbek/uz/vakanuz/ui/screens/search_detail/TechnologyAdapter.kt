package sanjarbek.uz.vakanuz.ui.screens.search_detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sanjarbek.uz.vakanuz.databinding.ItemChipBinding

class TechnologyAdapter(private val items: List<String>) :
    RecyclerView.Adapter<TechnologyAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemChipBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemChipBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvChipName.text = items[position]
    }

    override fun getItemCount(): Int = items.size
}
