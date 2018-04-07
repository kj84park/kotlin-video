package kr.kyungjoon.hansol.youtubevideo.ui.constants

import kr.kyungjoon.hansol.youtubevideo.ui.model.YoutubeModel

class DataConstants {

    companion object {
        val youtubeVideoList: List<YoutubeModel> = listOf(
                getOverviewModel("https://youtu.be/byOOlUfLGg4", "Guile’s Theme [arcade music / CPS-1] from Street Fighter 2 The Definitive Soundtrack"),
                getOverviewModel("https://youtu.be/FM-8Oot-iBE", "Ken’s Theme [arcade music / CPS-1] from Street Fighter 2 The Definitive Soundtrack"),
                getOverviewModel("https://youtu.be/41EZBpfOGDI", "Ryu’s Theme Theme [arcade music / CPS-1] from Street Fighter 2 The Definitive Soundtrack"),
                getOverviewModel("https://youtu.be/vD5HINFkiFA", "Balrog’s Theme [arcade music / CPS-1] from Street Fighter 2 The Definitive Soundtrack")
        )


        fun getOverviewModel(url: String, title: String): YoutubeModel {
            val id = url.replace("https://youtu.be/", "")
            return YoutubeModel("http://img.youtube.com/vi/$id/maxresdefault.jpg", title, url, id)
        }
    }
}
