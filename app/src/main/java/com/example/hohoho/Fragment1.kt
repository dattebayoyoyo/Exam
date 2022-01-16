package com.example.hohoho

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.main


class Fragment1 : Fragment(R.layout.activity_fragment1) {
    private lateinit var recyclerView: RecyclerView
    private lateinit var RecycleViewFlowersAdapter: RecycleViewFlowersAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()

        recyclerView = view.findViewById(R.id.recyclerView)
        RecycleViewFlowersAdapter = RecycleViewFlowersAdapter(getData())
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = RecycleViewFlowersAdapter

    }




    private fun getData(): List<Flowers>{

        val flowersList = ArrayList<Flowers>()
        flowersList.add(
            Flowers(
                1,
                "10 ლ.",
                "წითელი ვარდები",
                "https://www.avasflowers.net/img/prod_img/avasflowers-red-rose-masterpiece.jpg"
                    )
        )

        flowersList.add(
            Flowers(
                2,
                "15 ლ.",
                "ლურჯი ვარდები",
                "https://www.u-f-l.net/bouquet/sinie_rozyi_vip-7821_b.jpg"
            )
        )

        flowersList.add(
            Flowers(
                3,
                "20 ლ.",
                "ყვითელი ვარდები",
                "https://www.wineflowers.com/images/rosegialle_grande.jpg"
            )
        )

        flowersList.add(
            Flowers(
                4,
                "25 ლ.",
                "pink roses",
                "https://5.imimg.com/data5/KT/QK/MY-33139249/50-pink-roses-bouque-500x500.png"
            )
        )

        flowersList.add(
            Flowers(
                5,
                "30 ლ.",
                "bombastic",
                "https://www.roza4u.ru/image/cache/catalog/buket-bombastic/IMG_0207-1400x1400.jpg"
            )
        )

        flowersList.add(
            Flowers(
                6,
                "35 ლ.",
                "elegant",
                "https://dostavkatsvetov.org/img/goods/1565/buket-elegantnaya-foto-1.jpg"
            )

        )
        flowersList.add(
            Flowers(
                7,
                "40 ლ.",
                "valansole",
                "https://www.bouquet.kiev.ua/image/cache/catalog/products/wedd_bou/bouquets_wedd1_1-750x750-product_popup.jpg"
            )
        )
        flowersList.add(
            Flowers(
                8,
                "45 ლ.",
                "magic evening",
                "https://flowers.ua/images/Flowers/1462.jpg"
            )
        )
        flowersList.add(
            Flowers(
                9,
                "50 ლ.",
                "secret",
                "https://cdn.proflowers.ua/upload/images/showcase/1327.jpg"
            )
        )
        flowersList.add(
            Flowers(
                9,
                "55 ლ.",
                "gypsophils",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ4TZQGifD-8pSE5O0lq44H2poROmEBc3ZbgyxkfxdWQbnxydvKa0dcGr61LiuCR3PMeik&usqp=CAU"
            )
        )
        flowersList.add(
            Flowers(
                9,
                "60 ლ.",
                "magic",
                "https://www.rosemarkt.ru/resources/data/photos/5b7732ce62677/big.jpg"
            )
        )
        flowersList.add(
            Flowers(
                9,
                "95 ლ.",
                "roses",
                "https://flowershop.com.ua/wp-content/uploads/2018/06/buket-roz-122-2.jpg"
            )
        )
        flowersList.add(
            Flowers(
                9,
                "25 ლ.",
                "lovepeacejoy",
                "https://cdn.proflowers.ua/upload/images/showcase/1327.jpg"
            )
        )

        return flowersList



    }


}