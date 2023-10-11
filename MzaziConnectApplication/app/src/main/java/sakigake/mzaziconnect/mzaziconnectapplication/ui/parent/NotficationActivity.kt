package sakigake.mzaziconnect.mzaziconnectapplication.ui.parent

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.ContentResolver
import android.content.Context
import android.graphics.Color
import android.media.AudioAttributes
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import sakigake.mzaziconnect.mzaziconnectapplication.R

class NotificationActivity : AppCompatActivity() {

    companion object {
        const val NOTIFICATION_CHANNEL_ID = "10001"
        private const val default_notification_channel_id = "default"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notfication)

        val btnCreateNotification = findViewById<Button>(R.id.btnCreateNotification)
        btnCreateNotification.setOnClickListener {
            letsee()
        }
    }

    fun letsee(){
        val sound = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + packageName + "/raw/quite_impressed.mp3")
        val mBuilder = NotificationCompat.Builder(this@NotificationActivity, default_notification_channel_id)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("MzaziConnect")
            .setSound(sound)
            .setContentText("New Assignment")
        val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val audioAttributes = AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_ALARM)
                .build()
            val importance = NotificationManager.IMPORTANCE_HIGH
            val notificationChannel = NotificationChannel(NOTIFICATION_CHANNEL_ID, "NOTIFICATION_CHANNEL_NAME", importance)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.RED
            notificationChannel.enableVibration(true)
            notificationChannel.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
            notificationChannel.setSound(sound, audioAttributes)
            mBuilder.setChannelId(NOTIFICATION_CHANNEL_ID)
            mNotificationManager.createNotificationChannel(notificationChannel)
        }

        mNotificationManager.notify(System.currentTimeMillis().toInt(), mBuilder.build())

    }




}