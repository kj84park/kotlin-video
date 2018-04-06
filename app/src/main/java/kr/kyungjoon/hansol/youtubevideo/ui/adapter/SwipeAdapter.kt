package kr.kyungjoon.hansol.youtubevideo.ui.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import kr.kyungjoon.hansol.youtubevideo.R
import kr.kyungjoon.hansol.youtubevideo.ui.component.RecyclerViewFragment

class SwipeAdapter(fm : FragmentManager, private val context : Context) : FragmentStatePagerAdapter(fm) {

    private val tabTitles= arrayOf(context.getString(R.string.vidya_vox1),context.getString(R.string.vidya_vox2) )


    override fun getItem(position: Int): Fragment {
        return RecyclerViewFragment.newInstance(position+1)
    }

    override fun getCount(): Int {
        return tabTitles.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return tabTitles[position]
    }
}