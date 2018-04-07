package kr.kyungjoon.hansol.youtubevideo.ui.component

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kr.kyungjoon.hansol.youtubevideo.R
import kr.kyungjoon.hansol.youtubevideo.ui.adapter.YoutubeListAdapter
import kr.kyungjoon.hansol.youtubevideo.ui.constants.DataConstants

class RecyclerViewFragment : Fragment() {

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
                adapter = YoutubeListAdapter(it, DataConstants.youtubeVideoList, context)
            }
        }
        return recyclerView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
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

    private fun Context.toast(text: String) = Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}