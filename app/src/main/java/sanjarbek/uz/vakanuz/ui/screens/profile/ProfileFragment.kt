package sanjarbek.uz.vakanuz.ui.screens.profile

import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import sanjarbek.uz.vakanuz.R
import sanjarbek.uz.vakanuz.databinding.FragmentProfileBinding
import sanjarbek.uz.vakanuz.ui.base.BaseFragment

class ProfileFragment: BaseFragment(R.layout.fragment_profile) {
    private val binding: FragmentProfileBinding by viewBinding()
    override fun setup() {

    }

    override fun clicks() {
        super.clicks()
        with(binding){
            ivBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }
}