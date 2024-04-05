package com.palash.playaudiovideoonandroidwithexoplayer.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.palash.playaudiovideoonandroidwithexoplayer.R
import com.palash.playaudiovideoonandroidwithexoplayer.databinding.FragmentExoplayerBinding
import com.palash.playaudiovideoonandroidwithexoplayer.databinding.FragmentHomeBinding

class ExoplayerFragment : Fragment() {
    private var _binding: FragmentExoplayerBinding? = null
    private val binding get() = _binding!!
    lateinit var player : ExoPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExoplayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myArgument = arguments?.getString("myArgument")
        Log.d("MyVal", myArgument.toString())

        //initialize Exoplayer
        player = ExoPlayer.Builder(requireContext()).build()
        binding.playerView.player = player

        val mediaItem = MediaItem.fromUri(myArgument.toString())
        player.setMediaItem(mediaItem)
        player.prepare()
        player.play()
    }

    override fun onStart() {
        super.onStart()
        player.playWhenReady = true
    }

    override fun onStop() {
        super.onStop()
        player.playWhenReady = false
    }

    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}