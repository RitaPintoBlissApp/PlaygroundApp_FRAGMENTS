package com.example.playgroundapp_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.playgroundapp.AvatarAdapter
import com.example.playgroundapp_fragments.databinding.FragmentAvatarListBinding
import java.util.Random


class AvatarListFragment : Fragment() {

    private  var _binding: FragmentAvatarListBinding? =  null

    private val binding get() = _binding!!

    private lateinit var avatarList: MutableList<Int>
    private lateinit var adapter: AvatarAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        _binding = FragmentAvatarListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvAvatar.layoutManager = GridLayoutManager(context,4)

        avatarList = gerenateAvatarList()

        adapter = AvatarAdapter(avatarList){
            position -> removeAvatar(position)
        }

        binding.rvAvatar.adapter = adapter

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun gerenateAvatarList(): MutableList<Int>{
        val avatarList = mutableListOf<Int>()
        val originalAvatarList = listOf(
            R.drawable.profile1,
            R.drawable.profile2,
            R.drawable.profile3,
        )
        val random = Random()
        val repeateAvatar = originalAvatarList.flatMap { avatar -> List(100) {avatar} }.shuffled(random)


        avatarList.addAll(repeateAvatar)
        return avatarList
    }

    //remover o emoji da sua posição
    private fun removeAvatar(position: Int) {
        avatarList.removeAt(position)
        adapter.notifyItemRemoved(position)

    }


}