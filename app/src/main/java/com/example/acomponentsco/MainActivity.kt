package com.example.acomponentsco

import android.app.Notification
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.acomponentsco.fragments.ContactsFragment
import com.example.acomponentsco.fragments.MusicFragment
import com.example.acomponentsco.fragments.StartFragment
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.example.acomponentsco.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

const val CHANNEL_DEFAULT_IMPORTANCE = "31"


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val navigator = AppNavigator(this, R.id.fragment_container)

    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



supportFragmentManager.findFragmentById( R.id.fragment_container)
    ?:showStartFragment()

    }

    private fun showStartFragment() {
        ACompApplication.INSTANCE.router.newRootScreen(Screens.Start())
    }


    override fun onResumeFragments() {
        super.onResumeFragments()
        ACompApplication.INSTANCE.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        ACompApplication.INSTANCE.navigatorHolder.removeNavigator()
        super.onPause()
    }


    private fun tryToUseService(){
        val pendingIntent: PendingIntent =
            Intent(this, MainActivity::class.java).let { notificationIntent ->
                PendingIntent.getActivity(this, 0, notificationIntent,
                    PendingIntent.FLAG_IMMUTABLE)
            }

        val notification: Notification = Notification.Builder(this, CHANNEL_DEFAULT_IMPORTANCE)
            .setContentTitle(getText(R.string.notification_title))
            .setContentText(getText(R.string.notification_message))
            .setSmallIcon(R.drawable.notification_icon_foreground)
            .setContentIntent(pendingIntent)
            .setTicker(getText(R.string.ticker_text))
            .build()
    }

}

object Screens {
    fun Start() = FragmentScreen { StartFragment() }
    fun Contacts() = FragmentScreen { ContactsFragment() }
    fun Music() = FragmentScreen { MusicFragment() }
}