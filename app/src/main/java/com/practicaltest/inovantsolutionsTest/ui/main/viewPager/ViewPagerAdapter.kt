package com.practicaltest.inovantsolutionsTest.ui.main.viewPager


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter internal constructor(fm: FragmentManager,imageList: ArrayList<String>) :
    FragmentPagerAdapter(fm) {
    val newArrayList: ArrayList<String> = imageList
    lateinit var viewPagerMVPFragment: ViewPagerMVPFragment
    override fun getItem(position: Int): Fragment {
        val bundel: Bundle = Bundle()
        bundel.putString("obj", newArrayList[position])
        viewPagerMVPFragment = ViewPagerMVPFragment()
        viewPagerMVPFragment.arguments = bundel
        return viewPagerMVPFragment
    }

    override fun getCount(): Int {
        return newArrayList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return ""
    }
}
