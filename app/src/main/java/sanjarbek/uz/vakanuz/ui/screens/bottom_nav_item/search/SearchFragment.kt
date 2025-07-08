package sanjarbek.uz.vakanuz.ui.screens.bottom_nav_item.search

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import sanjarbek.uz.vakanuz.R
import sanjarbek.uz.vakanuz.databinding.FragmentSearchBinding
import sanjarbek.uz.vakanuz.domain.moc_data.AppHardCodeData
import sanjarbek.uz.vakanuz.ui.base.BaseFragment
import sanjarbek.uz.vakanuz.utils.Constants

class SearchFragment : BaseFragment(R.layout.fragment_search) {
    private val binding: FragmentSearchBinding by viewBinding()
    override fun setup() = with(binding) {

        val announcementAdapter = AnnouncementAdapter{
            val bundle = Bundle()
            bundle.putInt(Constants.String.ANNOUNCE_ID,it)
            findNavController().navigate(R.id.action_searchFragment_to_searchDetailFragment, bundle)
        }
        rvSearchScreen.adapter = announcementAdapter
        announcementAdapter.submitList(AppHardCodeData.announcementList)

    }

    override fun clicks()=with(binding) {
        super.clicks()
        cvProfile.setOnClickListener{
            findNavController().navigate(R.id.action_searchFragment_to_profileFragment)
        }
    }
}