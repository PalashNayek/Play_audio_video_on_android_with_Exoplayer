package com.palash.playaudiovideoonandroidwithexoplayer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.palash.playaudiovideoonandroidwithexoplayer.R
import com.palash.playaudiovideoonandroidwithexoplayer.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btn1.setOnClickListener {
            val url = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
            gotoPlayerPage(url)
        }

        binding.btn2.setOnClickListener {
            val url = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerMeltdowns.mp4"
            gotoPlayerPage(url)
        }

        binding.btn3.setOnClickListener {
            val url = "https://github.com/rafaelreis-hotmart/Audio-Sample-files/raw/master/sample.mp3"
            gotoPlayerPage(url)
        }
    }

    private fun gotoPlayerPage(url : String){
        val bundle = Bundle().apply {
            putString("myArgument", url)
        }
        findNavController().navigate(R.id.action_homeFragment_to_exoplayerFragment, bundle)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}