package sanjarbek.uz.vakanuz.ui.screens.search_detail

import android.annotation.SuppressLint
import android.text.TextUtils.substring
import android.view.View
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import sanjarbek.uz.vakanuz.R
import sanjarbek.uz.vakanuz.databinding.FragmentSearchDetailBinding
import sanjarbek.uz.vakanuz.domain.moc_data.AppHardCodeData
import sanjarbek.uz.vakanuz.ui.base.BaseFragment
import sanjarbek.uz.vakanuz.utils.Constants

@SuppressLint("SetTextI18n", "StringFormatInvalid")
class SearchDetailFragment : BaseFragment(R.layout.fragment_search_detail) {
    private val binding: FragmentSearchDetailBinding by viewBinding()

    override fun setup()= with(binding) {

        nestedScrollView.setOnScrollChangeListener {_, _, scrollY, _, _ ->
            if (scrollY > tvTollbarTitle.top) {
                tvTollbarTitle.visibility = View.VISIBLE
            } else {
                tvTollbarTitle.visibility = View.GONE
            }
        }



        val announcementId = arguments?.getInt(Constants.String.ANNOUNCE_ID,-1)

        if (announcementId != -1) {
            val announcement = AppHardCodeData.announcementList.find { it.id == announcementId }
            announcement?.let { it ->
                tvTollbarTitle.text = if ((it.jobName?.length ?: -1) > 20) {
                    it.jobName?.substring(0, 19) + " ..."
                } else {
                    it.jobName
                }
                tvJobName.text = it.jobName
                    tvPrice.text = "${it.minPrice} - ${it.maxPrice} UZS"
                    tvRegion.text = requireContext().getString(R.string.str_region) + " " + it.region
                    tvEmployment.text = requireContext().getString(R.string.str_employment) + " " + it.employment
                    tvExperience.text = requireContext().getString(R.string.str_experience) + " " + it.experience
                    tvGraph.text = requireContext().getString(R.string.str_graph) + " " + it.graph
                    tvWorkingTime.text = requireContext().getString(R.string.str_working_time) + " " + it.workingTime
                    tvWorkFormat.text = requireContext().getString(R.string.str_work_format) + " " + it.workFormat
                    tvOrganization.text = it.organization
                    tvPurposeWork.text = it.purposeWork
                    tvRequirements.text = it.requirements
                    tvWeOffer.text = it.weOffer
                    tvAdditionalInformation.text = it.additionalInformation

                    val technologyString = it.technology
                    val technologyList = technologyString?.split(",")?.map { it.trim() }
                    val technologyAdapter = technologyList?.let { it1 -> TechnologyAdapter(it1) }
                    rvTechnology.layoutManager = FlexboxLayoutManager(requireContext()).apply {
                        flexDirection = FlexDirection.ROW
                        justifyContent = JustifyContent.FLEX_START
                        flexWrap = FlexWrap.WRAP
                    }
                    rvTechnology.adapter = technologyAdapter

                    val languageString = it.languages
                    val languageList = languageString?.split(",")?.map { it.trim() }
                    val languageAdapter = languageList?.let { it1 -> TechnologyAdapter(it1) }
                    rvLanguage.layoutManager = FlexboxLayoutManager(requireContext()).apply {
                        flexDirection = FlexDirection.ROW
                        justifyContent = JustifyContent.FLEX_START
                        flexWrap = FlexWrap.WRAP
                    }
                    rvLanguage.adapter = languageAdapter
            }
        }
    }

    override fun clicks() {
        super.clicks()
        with(binding) {
            ivBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }
}