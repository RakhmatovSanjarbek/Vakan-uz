package sanjarbek.uz.vakanuz.ui.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import sanjarbek.uz.vakanuz.R
import sanjarbek.uz.vakanuz.utils.extentions.color

abstract class BaseFragment(
    @LayoutRes layoutId: Int,
) :Fragment(layoutId){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
        clicks()
        observers()
        setBackgroundColorToScreen(view)
    }

    abstract fun setup()
    open fun setup(view: View){}
    open fun clicks(){}
    open fun observers(){}
    open fun setBackgroundColorToScreen(view: View, color: Int = R.color.color_for_screen) {
        view.setBackgroundColor(color(color))
    }
}