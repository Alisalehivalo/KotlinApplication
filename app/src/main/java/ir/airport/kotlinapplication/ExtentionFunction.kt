package ir.airport.kotlinapplication

import android.app.Notification
import android.content.Context
import androidx.fragment.app.Fragment
import android.net.NetworkInfo
import androidx.core.content.ContextCompat.getSystemService
import android.net.ConnectivityManager
import androidx.core.app.NotificationCompat


fun Context.showToast(message:String,duration:Int= android.widget.Toast.LENGTH_SHORT){
    android.widget.Toast.makeText(this, message , duration).show()
}

fun Context.notification(channelId: String, func:
NotificationCompat.Builder.() -> Unit): Notification {
    val builder = NotificationCompat.Builder(this, channelId)
    builder.func()
    return builder.build()
}