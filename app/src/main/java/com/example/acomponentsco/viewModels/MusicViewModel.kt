package com.example.acomponentsco.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.acomponentsco.R
import com.example.acomponentsco.service.MusicPlayer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class MusicViewModel @Inject constructor(
    private val musicPlayer: MusicPlayer
) : ViewModel() {


    fun startStopPlaying() = musicPlayer.startStopPlaying()

    fun nextTrack() = musicPlayer.nextTrack()

    fun prevTrack() = musicPlayer.prevTrack()

/*    var playinIconId: MutableLiveData<Int> = MutableLiveData(
        if (musicPlayer.isPlaying) {
            R.drawable.ic_play_foreground
        } else {
            R.drawable.pause_icon_foreground
        }
    )*/

    var playingIconId =
        musicPlayer.isPlayingFlow.map {
            if (it) {
                R.drawable.pause_icon_foreground
            } else {
                R.drawable.ic_play_foreground
            }
        }








}