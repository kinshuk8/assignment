package com.kinshuk.assignemnt

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loadBtn = findViewById<Button>(R.id.load_api_btn)

        loadBtn.setOnClickListener {
            loadContent()
        }

        val refreshBtn = findViewById<Button>(R.id.refresh_api_btn)

        refreshBtn.setOnClickListener {
            loadContent()
        }

    }

    private fun loadContent() {
        val queue = Volley.newRequestQueue(this)
        val url = "https://catfact.ninja/fact"

        val stringRequest = StringRequest(Request.Method.GET, url,
            { response ->
                // Display the response string in a TextView.
                val textView = findViewById<TextView>(R.id.content_text)
                textView.text = response
            },
            { error ->
                // Handle error
                Log.e("API Error", error.toString())
            })

        queue.add(stringRequest)
    }
}

