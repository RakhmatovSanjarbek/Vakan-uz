package sanjarbek.uz.vakanuz.ui.screens.bottom_nav_item.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import sanjarbek.uz.vakanuz.R
import sanjarbek.uz.vakanuz.databinding.ItemSearchScreenBinding
import sanjarbek.uz.vakanuz.domain.models.announcement.AnnouncementModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class AnnouncementAdapter(
    private val onItemClick: (announcementId: Int) -> Unit,
):
    ListAdapter<AnnouncementModel, AnnouncementAdapter.AnnouncementViewHolder>(DiffCallback()) {

    inner class AnnouncementViewHolder(private val binding: ItemSearchScreenBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: AnnouncementModel) = with(binding) {
            tvDate.text =
                SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date(item.date ?: 0))
            tvJobName.text = item.jobName
            tvOrganization.text = item.organization
            tvRegion.text = item.region
            val context = binding.root.context
            tvExperience.text = if (!item.experience.isNullOrBlank()) {
                context.getString(R.string.str_experience) + " " + item.experience
            } else {
                context.getString(R.string.str_without_experience)
            }

            val priceText = if (!item.minPrice.isNullOrBlank() && !item.maxPrice.isNullOrBlank()) {
                "${item.minPrice} - ${item.maxPrice} UZS"
            } else {
                root.context.getString(R.string.str_price)
            }
            tvPrice.text = priceText

            root.setOnClickListener {
                item.id?.let { it1 -> onItemClick(it1) }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnnouncementViewHolder {
        val binding =
            ItemSearchScreenBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnnouncementViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnnouncementViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DiffCallback : DiffUtil.ItemCallback<AnnouncementModel>() {
        override fun areItemsTheSame(
            oldItem: AnnouncementModel,
            newItem: AnnouncementModel,
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: AnnouncementModel,
            newItem: AnnouncementModel,
        ): Boolean {
            return oldItem == newItem
        }
    }
}
