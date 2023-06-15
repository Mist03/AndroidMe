package com.example.diploma_mk.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.diploma_mk.AdapterClass
import com.example.diploma_mk.DATA.DataClass
import com.example.diploma_mk.R

class TestingFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<DataClass>
    lateinit var imageList: Array<Int>
    lateinit var titleList: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_testing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageList = arrayOf(
            R.drawable.icon_kotlin,
            R.drawable.icon_design
        )

        titleList = arrayOf(
            getString(R.string.titleKotlin),
            getString(R.string.titleDesigne)
        )

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf<DataClass>()
        getData()
    }

    private fun getData(){
        for (i in imageList.indices){
            val dataClass = DataClass(imageList[i], titleList[i])
            dataList.add(dataClass)

        }
        recyclerView.adapter = AdapterClass(dataList, 4)
    }
}
