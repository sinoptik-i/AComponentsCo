package com.example.acomponentsco.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.acomponentsco.databinding.FragmentMusicBinding
import com.example.acomponentsco.viewModels.MusicViewModel
import kotlinx.coroutines.launch


class MusicFragment : Fragment() {

    private lateinit var binding: FragmentMusicBinding

    private val musicViewModel: MusicViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMusicBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //ActivityResultContracts.RequestPermission
        with(binding) {
            ibtnPlayStop.setOnClickListener {
                musicViewModel.startStopPlaying()
            }

            /*    musicViewModel.playinIconId.observe(viewLifecycleOwner){

                }*/
            lifecycleScope.launch {
                musicViewModel.playingIconId.collect(ibtnPlayStop::setImageResource)
            }

            ibtnNext.setOnClickListener {
                musicViewModel.nextTrack()
            }
            ibtnPrev.setOnClickListener {
                musicViewModel.prevTrack()
            }
        }
    }


}