package com.seanutf.learn.toyandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.seanutf.learn.toyandroid.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val listAdapter = MainListAdapter(::openRouter)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvList.adapter = listAdapter
        listAdapter.updateList(getListData())
        lifecycleScope.launch {
            flow<Boolean> {

            }.collectLatest {

            }
        }
    }

    private fun openRouter(position: Int){

    }

    private fun getListData(): MutableList<String> {
        val list = mutableListOf<String>()
        list.add("E")
        list.add("N")
        list.add("C")
        list.add("T")
        list.add("O")
        list.add("G")

        return list
    }
}