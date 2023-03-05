package com.example.acomponentsco.service

import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import com.example.acomponentsco.contentProvider.FileManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOf
import java.text.FieldPosition
import javax.inject.Inject

class MusicPlayer @Inject constructor(
    val context: Context,
    fileManager: FileManager
) {
    //ExoPlayer
    private val tracksUri = fileManager.getMusicUri() ?: emptyList()

    private var trackPosition = 0

    private var currentTrack = MediaPlayer.create(context, tracksUri.get(trackPosition));
    private var isPlayingState = MutableStateFlow(currentTrack.isPlaying)

    val isPlayingFlow: Flow<Boolean>
        get() = isPlayingState


    init {
        currentTrack.setOnCompletionListener {
            it.stop()
        }
    }

    fun nextTrack() {
        trackPosition = ++trackPosition % tracksUri.size
        changeTRack(trackPosition)
    }

    private fun changeTRack(position: Int) {
        currentTrack.stop()// ololo bez etogo
        currentTrack = MediaPlayer.create(context, tracksUri[position])
        currentTrack.start()
        isPlayingState.value = currentTrack.isPlaying
    }

    fun prevTrack() {
        trackPosition--
        if (trackPosition < 0) {
            trackPosition = tracksUri.size - 1
        }
        changeTRack(trackPosition)
    }


    fun startStopPlaying() {
        try {
            if (currentTrack.isPlaying) {
                currentTrack.pause()
            } else {
                currentTrack.start()
            }
            isPlayingState.value = currentTrack.isPlaying
        } catch (ex: Exception) {
            Log.e(this.javaClass.simpleName, ex.message.toString())
        }
    }

}