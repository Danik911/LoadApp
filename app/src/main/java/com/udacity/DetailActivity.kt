package com.udacity

import android.app.NotificationManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*


const val DETAIL_ACTIVITY_KEY = "Status"
const val DETAIL_ACTIVITY_FILENAME_KEY = "Filename"

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)

        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.cancelAll()

        val fileName = intent.getStringExtra(DETAIL_ACTIVITY_KEY)
        fileNameValue.text = fileName

        val status = intent.getStringExtra(DETAIL_ACTIVITY_FILENAME_KEY)
        statusValue.text = status

        button.setOnClickListener {
            finish()
        }

    }

}
