package com.cs407.alderassist_tutorial

import android.content.Intent
import android.os.Bundle
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.text.Editable

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: VideoAdapter
    private lateinit var recyclerView: RecyclerView
    private val videoList = listOf(
        VideoItem("How to use Google Maps on Android phone to navigate", "Xo7yywC9iPk"),
        VideoItem("How To Use Google Maps! (Complete Beginners Guide)", "tui9hq9lfsU"),
        VideoItem("How To Send A Text Message On Any Android Phone", "rfA83_bhdXw"),
        VideoItem("How to Setup Any Email on Android 2019", "KL2PsdyAXXY"),
        VideoItem("The Best How to Send an Email With an Android Phone or Tablet", "sYHxF98TU9k"),
        VideoItem("Make calls using Google Voice on Android using Google Workspace for business\n", "jWhnE9wUOQE"),
        VideoItem("Galaxy S23's: How to Make a Phone Call", "_-qm3BCLP1Y")
    )
    private var filteredList = videoList.toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "Video list size: ${videoList.size}")

        val searchBar = findViewById<EditText>(R.id.searchBar)
        val searchButton = findViewById<Button>(R.id.searchButton)
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        adapter = VideoAdapter(filteredList) { videoId ->
            val intent = Intent(this, VideoActivity::class.java)
            intent.putExtra("VIDEO_ID", videoId)
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        searchButton.setOnClickListener {
            val query = searchBar.text.toString().trim()
            filterVideos(query)
        }

        searchBar.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val query = s.toString().trim()
                filterVideos(query)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }
    private fun filterVideos(query: String) {
        filteredList.clear()
        if (query.isEmpty()) {
            filteredList.addAll(videoList)
        } else {
            filteredList.addAll(videoList.filter { it.title.contains(query, ignoreCase = true) })
        }
        adapter.notifyDataSetChanged()
    }
}