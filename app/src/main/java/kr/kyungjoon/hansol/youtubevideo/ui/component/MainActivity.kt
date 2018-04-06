package kr.kyungjoon.hansol.youtubevideo.ui.component

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kr.kyungjoon.hansol.youtubevideo.R
import kr.kyungjoon.hansol.youtubevideo.ui.adapter.SwipeAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter by lazy {
        SwipeAdapter(supportFragmentManager,this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewpager.adapter= adapter
        tablayout.setupWithViewPager(viewpager)
    }
}
