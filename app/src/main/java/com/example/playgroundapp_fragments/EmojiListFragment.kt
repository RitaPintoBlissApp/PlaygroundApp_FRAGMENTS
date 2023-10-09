package com.example.playgroundapp_fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.playgroundapp_fragments.databinding.FragmentEmojiListBinding
import java.util.Random


@Suppress("DEPRECATION")
class EmojiListFragment : Fragment() {

    private  var _binding: FragmentEmojiListBinding? =  null

    private val binding get() = _binding!!

    private lateinit var emojiList: MutableList<Int>
    private lateinit var adapter: EmojiAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentEmojiListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        binding.rvEmoji.layoutManager = GridLayoutManager(context,4)


        emojiList = generateEmojiList()

        adapter = EmojiAdapter(emojiList){
                position -> removeEmoji(position)
        }

        binding.rvEmoji.adapter = adapter

        binding.swipeRefreshLayout.setOnRefreshListener {
            refreshEmojiList()
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



    private fun generateEmojiList(): MutableList<Int> {
        val emojiList = mutableListOf<Int>()
        val originalEmojiList = listOf(
            R.drawable.dislike,
            R.drawable.hundred,
            R.drawable.like,
            R.drawable.numbers,


            )
        val random = Random()
        //flatmap
        val repeatedEmojis = originalEmojiList.flatMap { emoji -> List(100) { emoji } }.shuffled(random)

        //ciclo for
        /*for (emoji in originalEmojiList) {
        repeat(25) {
            emojiList.add(emoji)
        }
        }*/

        emojiList.addAll(repeatedEmojis)
        return emojiList
    }


    @SuppressLint("NotifyDataSetChanged")
    private fun removeEmoji(position: Int) {
        emojiList.removeAt(position)
        adapter.notifyDataSetChanged()
    }


    @SuppressLint("NotifyDataSetChanged")
    private fun refreshEmojiList() {
        Handler().postDelayed({ //2 sec of delay
            emojiList.clear() //clean all
            emojiList.addAll(generateEmojiList()) // new list
            adapter.notifyDataSetChanged() // notification of the change
            binding.swipeRefreshLayout.isRefreshing = false //just to know when the refresh is over
        }, 2000)
    }


}