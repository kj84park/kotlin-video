package kr.kyungjoon.hansol.youtubevideo.ui.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.youtube.player.YouTubeIntents
import com.google.android.youtube.player.YouTubeStandalonePlayer
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_overview.view.*
import kr.kyungjoon.hansol.youtubevideo.R
import kr.kyungjoon.hansol.youtubevideo.ui.constants.AppConstants
import kr.kyungjoon.hansol.youtubevideo.ui.model.YoutubeModel

class YoutubeListAdapter(var activity: Activity, var overviewList: List<YoutubeModel>, var mContext: Context) : RecyclerView.Adapter<YoutubeListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_overview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindOverviewVideos(overviewList[position], activity)
    }

    override fun getItemCount(): Int {
        return overviewList.size
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bindOverviewVideos(overview: YoutubeModel, activity: Activity) {

            with(overview) {
                Picasso.with(view.context).load(overview.imageUrl).into(view.iv_main)
                YoutubeListAdapter.setNineBySixteenHeight(view.context, view.iv_main)
                view.tv_title.text = overview.title
                view.setOnClickListener { view ->

                    if (YouTubeIntents.canResolvePlayVideoIntent(view.context)) {
                        val intent: Intent = YouTubeStandalonePlayer.createVideoIntent(
                                activity, AppConstants.GOOGLE_DEVELOPER_KEY, overview.videoId, 0, true, true)

                        startActivity(view.context, intent, null)

                    } else {
                        Toast.makeText(view.context, "Youtube App is not present in the device", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    companion object {
        fun setNineBySixteenHeight(context: Context, view: View) {
            val display = (context as AppCompatActivity).windowManager.defaultDisplay
            val width = display.width
            val height = width * 9 / 16
            view.layoutParams.height = height
        }
    }

}