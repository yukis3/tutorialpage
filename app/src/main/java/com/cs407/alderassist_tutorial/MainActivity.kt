package com.cs407.alderassist_tutorial

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.GridLayoutManager
import com.cs407.alderassist_tutorial.model.VideoItem
import com.cs407.alderassist_tutorial.model.VideoAdapter

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
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    // Sample video data (replace with actual YouTube thumbnails and titles)
    val videoList = listOf(
        VideoItem("Video 1", R.drawable.thumbnail1),
        VideoItem("Video 2", R.drawable.thumbnail2),
        VideoItem("Video 3", R.drawable.thumbnail3),
        VideoItem("Video 4", R.drawable.thumbnail4),
        VideoItem("Video 5", R.drawable.thumbnail5),
        VideoItem("Video 6", R.drawable.thumbnail6),
        VideoItem("Video 7", R.drawable.thumbnail7),
        VideoItem("Video 8", R.drawable.thumbnail8),
        VideoItem("Video 9", R.drawable.thumbnail9)
    )

    val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
    recyclerView.layoutManager = GridLayoutManager(this, 2) // 2 columns
    recyclerView.adapter = VideoAdapter(videoList)
}
}