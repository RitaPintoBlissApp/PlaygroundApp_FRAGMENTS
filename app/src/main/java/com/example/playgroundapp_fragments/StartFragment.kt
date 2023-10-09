package com.example.playgroundapp_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.playgroundapp.emojis
import com.example.playgroundapp_fragments.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private  var _binding: FragmentStartBinding? =  null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        randomEmoji()
        gotoAvatarList()
        gotoEmojiList()
        gotoGoogleRepo()
    }

    private fun randomEmoji(){
        binding.btRandomEmoji.setOnClickListener {
            val randomIndex = (emojis.indices).random()
            val randomemoji = emojis[randomIndex]
            binding.imageView.setImageResource(randomemoji)
        }
    }

    private fun gotoEmojiList(){
        //navega até emojilistfrgament
        binding.btEmojiList.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_emojiListFragment)
        }

    }

    private fun gotoAvatarList(){
        binding.btAvatarList.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_avatarListFragment)
        }
    }


    private fun gotoGoogleRepo(){
        binding.btGoogleRepos.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_googleRepoFragment2)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
