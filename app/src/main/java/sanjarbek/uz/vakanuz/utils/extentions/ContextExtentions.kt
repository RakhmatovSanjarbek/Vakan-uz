package sanjarbek.uz.vakanuz.utils.extentions

import android.content.Context
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

fun Context.color(@ColorRes colorRes: Int) = ContextCompat.getColor(this, colorRes)