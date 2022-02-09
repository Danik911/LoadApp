package com.udacity

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

private const val NOTIFICATION_ID = 0

fun NotificationManager.sendNotification(
    channelId: String,
    message: String,
    context: Context,
    fileName: String,
    status: String
) {
    val detailActivityIntent = Intent(context, DetailActivity::class.java)
    detailActivityIntent.putExtra(DETAIL_ACTIVITY_KEY, status)
    detailActivityIntent.putExtra(DETAIL_ACTIVITY_FILENAME_KEY, fileName)

    val buttonPendingIntent = PendingIntent.getActivity(
        context,
        NOTIFICATION_ID,
        detailActivityIntent,
        PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
    )
    val builder = NotificationCompat.Builder(context, channelId)
        .setSmallIcon(R.drawable.ic_assistant_black_24dp)
        .setContentTitle(context.getString(R.string.notification_title))
        .setContentText(message)
        .setAutoCancel(true)
        .addAction(
            R.drawable.ic_assistant_black_24dp,
            context.getString(R.string.notification_button),
            buttonPendingIntent
        )
        .setPriority(NotificationCompat.PRIORITY_HIGH)

    notify(NOTIFICATION_ID, builder.build())
}