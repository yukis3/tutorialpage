package com.cs407.alderassist_tutorial

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val videoList = listOf(
            VideoItem("How to use Google Maps on Android phone to navigate", "Xo7yywC9iPk"),
            VideoItem("How To Use Google Maps! (Complete Beginners Guide)", "tui9hq9lfsU"),
            VideoItem("How To Send A Text Message On Any Android Phone", "rfA83_bhdXw"),
            VideoItem("How to Setup Any Email on Android 2019", "KL2PsdyAXXY"),
            VideoItem("The Best How to Send an Email With an Android Phone or Tablet", "sYHxF98TU9k"),
            VideoItem("Make calls using Google Voice on Android using Google Workspace for business\n", "jWhnE9wUOQE"),
            VideoItem("Galaxy S23's: How to Make a Phone Call", "_-qm3BCLP1Y")
        )
        Log.d("MainActivity", "Video list size: ${videoList.size}")

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = VideoAdapter(videoList) { videoId ->
            val intent = Intent(this, VideoActivity::class.java)
            intent.putExtra("VIDEO_ID", videoId)
            startActivity(intent)
        }
        recyclerView.setItemViewCacheSize(0)
        recyclerView.recycledViewPool.clear()
    }
}