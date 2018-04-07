package kr.kyungjoon.hansol.youtubevideo.ui.constants

import kr.kyungjoon.hansol.youtubevideo.ui.model.YoutubeModel

class DataConstants {
    companion object {
        val youtubeVideoList_01: List<YoutubeModel> = listOf(
                getOverviewModel("https://youtu.be/byOOlUfLGg4", "Guile’s Theme [arcade music / CPS-1] from Street Fighter 2 The Definitive Soundtrack"),
                getOverviewModel("https://youtu.be/FM-8Oot-iBE", "Ken’s Theme [arcade music / CPS-1] from Street Fighter 2 The Definitive Soundtrack"),
                getOverviewModel("https://youtu.be/41EZBpfOGDI", "Ryu’s Theme Theme [arcade music / CPS-1] from Street Fighter 2 The Definitive Soundtrack"),
                getOverviewModel("https://youtu.be/vD5HINFkiFA", "Balrog’s Theme [arcade music / CPS-1] from Street Fighter 2 The Definitive Soundtrack")
        )

        val youtubeVideoList_02: List<YoutubeModel> = listOf(
                getOverviewModel("https://youtu.be/T1QM0CF7YpU", "(NewAge Piano),2 HOURS The Best Relaxing Music"),
                getOverviewModel("https://youtu.be/FAJbEQJpIKA", "Jazz Piano Music 10 Hours"),
                getOverviewModel("https://youtu.be/XcuYoZug5iM", "Relaxing Coffee JAZZ - Cafe Saxophone & Piano Jazz Music for Work,Studying, Relaxing"),
                getOverviewModel("https://youtu.be/sMU6qEetzeo", "New Age Piano Music: Carlo Balzaretti | Classical Music")
        )

        fun getOverviewModel(url: String, title: String): YoutubeModel {
            val id = url.replace("https://youtu.be/", "")
            return YoutubeModel("http://img.youtube.com/vi/$id/maxresdefault.jpg", title, url, id)
        }
    }
}
