package sanjarbek.uz.vakanuz.domain.models.announcement

data class AnnouncementModel(
    val id: Int? = null,
    val category: String? = null,
    val date: Long? = null,
    val organization: String? = null,
    val region: String? = null,
    val jobName: String? = null,
    val purposeWork: String? = null,
    val requirements: String? = null,
    val weOffer: String? = null,
    val technology: String? = null,
    val languages: String? = null,
    val additionalInformation: String? = null,
    val experience: String? = null,
    val employment: String? = null,
    val graph: String? = null,
    val workingTime: String? = null,
    val workFormat: String? = null,
    val minPrice: String? = null,
    val maxPrice: String? = null,
    val phoneNumber: String? = null,
)
