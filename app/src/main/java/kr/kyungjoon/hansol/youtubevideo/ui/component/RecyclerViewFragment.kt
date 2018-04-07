package kr.kyungjoon.hansol.youtubevideo.ui.component

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.kyungjoon.hansol.youtubevideo.R
import kr.kyungjoon.hansol.youtubevideo.ui.adapter.YoutubeModelListAdapter
import kr.kyungjoon.hansol.youtubevideo.ui.constants.DataConstants

class RecyclerViewFragment() : Fragment() {

    private var mPage: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.run {
            mPage = getInt(ARG_PAGE)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val recyclerView = inflater.inflate(R.layout.item_recycler_view, container, false) as RecyclerView
        recyclerView.run {
            layoutManager = LinearLayoutManager(context)
            hasFixedSize()

            activity?.let {
                adapter = if(mPage == 1){
                    YoutubeModelListAdapter(it, DataConstants.youtubeVideoList_01, context)
                } else {
                    YoutubeModelListAdapter(it, DataConstants.youtubeVideoList_02, context)
                }
            }
        }
        return recyclerView
    }

    companion object {
        val ARG_PAGE = "ARG_PAGE"

        fun newInstance(page: Int): RecyclerViewFragment {

            val args = Bundle()
            args.apply {
                putInt(ARG_PAGE, page)
            }

            val fragment = RecyclerViewFragment()
            fragment.apply {
                arguments = args
            }

            return fragment
        }
    }
}