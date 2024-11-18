package com.cs407.alderassist_tutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient


class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//    }
//override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
//    setContentView(R.layout.activity_main)
//
//    // Sample video data (replace with actual YouTube thumbnails and titles)
//    val videoList = listOf(
//        VideoItem("Video 1", R.drawable.thumbnail1),
//        VideoItem("Video 2", R.drawable.thumbnail2),
//        VideoItem("Video 3", R.drawable.thumbnail3),
//        VideoItem("Video 4", R.drawable.thumbnail4),
//        VideoItem("Video 5", R.drawable.thumbnail5),
//        VideoItem("Video 6", R.drawable.thumbnail6),
//        VideoItem("Video 7", R.drawable.thumbnail7),
//        VideoItem("Video 8", R.drawable.thumbnail8),
//        VideoItem("Video 9", R.drawable.thumbnail9)
//    )
//
//    val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
//    recyclerView.layoutManager = GridLayoutManager(this, 2) // 2 columns
//    recyclerView.adapter = VideoAdapter(videoList)
//}
private lateinit var youtubeWebView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 初始化 WebView
        youtubeWebView = findViewById(R.id.youtubeWebView)

        // 设置 WebView 属性
        val webSettings: WebSettings = youtubeWebView.settings
        webSettings.javaScriptEnabled = true  // 启用 JavaScript
        webSettings.loadWithOverviewMode = true  // 自适应屏幕
        webSettings.useWideViewPort = true  // 支持缩放

        // 在 WebView 加载页面时保持在应用内
        youtubeWebView.webViewClient = WebViewClient()

        // 加载 YouTube 视频
        loadYouTubeVideo("Xo7yywC9iPk&list=PL1C6MwCo82im0anFyIdvjXl7nej1Y0Dd7") // 替换为您的视频 ID
    }

    private fun loadYouTubeVideo(videoId: String) {
        val videoUrl = "https://www.youtube.com/watch?v=Xo7yywC9iPk&list=PL1C6MwCo82im0anFyIdvjXl7nej1Y0Dd7"
        youtubeWebView.loadUrl(videoUrl)
    }
}