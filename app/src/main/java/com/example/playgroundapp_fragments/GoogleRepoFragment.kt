package com.example.playgroundapp_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.playgroundapp_fragments.databinding.FragmentGoogleRepoBinding

class GoogleRepoFragment : Fragment() {
    private  var _binding: FragmentGoogleRepoBinding? =  null

    private val binding get() = _binding!!

    private lateinit var repoList:MutableList<String>
    private lateinit var adapter: GoogleRepoAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentGoogleRepoBinding.inflate(inflater,container,false)
        val view = binding.root
        return view


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        binding.rvGoogleRepos.layoutManager = LinearLayoutManager(context)

        repoList = generateRepoList()
        adapter = GoogleRepoAdapter(repoList)
        binding.rvGoogleRepos.adapter = adapter
    }



}


private fun generateRepoList():MutableList<String>{
    val list = mutableListOf<String>()
    val value1 = "google/.github"
    val value2 = "google/acai"

    for (i in 1..50) {
        list.add(value1)
        list.add(value2)
    }

    return list
}