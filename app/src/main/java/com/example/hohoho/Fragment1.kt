package com.example.hohoho

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Fragment1 : Fragment(R.layout.activity_fragment1) {
    private lateinit var recyclerView: RecyclerView
    private lateinit var RecycleViewPersonAdapter: RecycleViewPersonAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()

        recyclerView = view.findViewById(R.id.recyclerView)
        RecycleViewPersonAdapter = RecycleViewPersonAdapter(getData())
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = RecycleViewPersonAdapter
    }
    private fun getData(): List<Person>{

        val personList = ArrayList<Person>()
        personList.add(
            Person(
                1,
                "guka",
                "Guka",
                "https://static1.moviewebimages.com/wordpress/wp-content/uploads/article/85x5aGEhHxVubQAdoNXGuyaXkdWQye.jpg"
            )
        )

        personList.add(
            Person(
                2,
                "faziko",
                "Ne Znakomlyus",
                "https://thumbs.dreamstime.com/b/sexy-macho-man-24891058.jpg"
            )
        )

        personList.add(
            Person(
                3,
                "layla",
                "Magic is everywhere",
                "https://i.ytimg.com/vi/gAsFmZCGhLc/hqdefault.jpg"
            )
        )

        personList.add(
            Person(
                4,
                "zebra",
                "Jvarshi nagdad var",
                "https://i.ytimg.com/vi/gAsFmZCGhLc/hqdefault.jpg"
            )
        )

        personList.add(
            Person(
                5,
                "abassha",
                "I'm the best",
                "https://i.ytimg.com/vi/gAsFmZCGhLc/hqdefault.jpg"
            )
        )







        return personList
    }
}