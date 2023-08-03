package com.example.fragment_test_001

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Fragment2 : Fragment() {

    private lateinit var adapter : MyAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var areaArrayList: ArrayList<Model>

    lateinit var titleId : Array<String>
    lateinit var desId : Array<String>
    private lateinit var imageId : Array<Int>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerview)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = MyAdapter(areaArrayList)
        adapter.itemClick = object: MyAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                when (position) {
                    0 -> {
                        //서울 연결
                        val seoulIntent = Intent(activity, SeoulActivity::class.java)
                        seoulIntent.putExtra("code", 1)
                        startActivity(seoulIntent)
                    }
                    1 -> {
                        //인천 연결
                        val incheonIntent = Intent(activity, SeoulActivity::class.java)
                        incheonIntent.putExtra("code", 2)
                        startActivity(incheonIntent)
                    }
                    2 -> {
                        //대전 연결
                        val daejeonIntent = Intent(activity, SeoulActivity::class.java)
                        daejeonIntent.putExtra("code", 3)
                        startActivity(daejeonIntent)
                    }
                    3 -> {
                        //대구 연결
                        val daeguIntent = Intent(activity, SeoulActivity::class.java)
                        daeguIntent.putExtra("code", 4)
                        startActivity(daeguIntent)
                    }
                    4 -> {
                        //광주 연결
                        val gwangjuIntent = Intent(activity, SeoulActivity::class.java)
                        gwangjuIntent.putExtra("code", 5)
                        startActivity(gwangjuIntent)
                    }
                    5 -> {
                        //부산 연결
                        val busanIntent = Intent(activity, SeoulActivity::class.java)
                        busanIntent.putExtra("code", 6)
                        startActivity(busanIntent)
                    }
                    6 -> {
                        //울산 연결
                        val ulsanIntent = Intent(activity, SeoulActivity::class.java)
                        ulsanIntent.putExtra("code", 7)
                        startActivity(ulsanIntent)
                    }
                    7 -> {
                        //세종 연결
                        val sejongIntent = Intent(activity, SeoulActivity::class.java)
                        sejongIntent.putExtra("code", 8)
                        startActivity(sejongIntent)
                    }
                    8 -> {
                        //경기 연결
                        val gyeongiIntent = Intent(activity, SeoulActivity::class.java)
                        gyeongiIntent.putExtra("code", 9)
                        startActivity(gyeongiIntent)
                    }
                    9 -> {
                        //강원 연결
                        val gangWonIntent = Intent(activity, SeoulActivity::class.java)
                        gangWonIntent.putExtra("code", 10)
                        startActivity(gangWonIntent)
                    }
                    10 -> {
                        //충북 연결
                        val chungBukIntent = Intent(activity, SeoulActivity::class.java)
                        chungBukIntent.putExtra("code", 11)
                        startActivity(chungBukIntent)
                    }
                    11 -> {
                        //충남 연결
                        val chungNamIntent = Intent(activity, SeoulActivity::class.java)
                        chungNamIntent.putExtra("code", 12)
                        startActivity(chungNamIntent)
                    }
                    12 -> {
                        //경상북도 연결
                        val gyeongSangBukDoIntent = Intent(activity, SeoulActivity::class.java)
                        gyeongSangBukDoIntent.putExtra("code", 13)
                        startActivity(gyeongSangBukDoIntent)
                    }
                    13 -> {
                        //경상남도 연결
                        val gyeongSangNamDoIntent = Intent(activity, SeoulActivity::class.java)
                        gyeongSangNamDoIntent.putExtra("code", 14)
                        startActivity(gyeongSangNamDoIntent)
                    }
                    14 -> {
                        //전라북도 연결
                        val jeolLaBukDoIntent = Intent(activity, SeoulActivity::class.java)
                        jeolLaBukDoIntent.putExtra("code", 15)
                        startActivity(jeolLaBukDoIntent)
                    }
                    15 -> {
                        //전라남도 연결
                        val jeolLaNamDoIntent = Intent(activity, SeoulActivity::class.java)
                        jeolLaNamDoIntent.putExtra("code", 16)
                        startActivity(jeolLaNamDoIntent)
                    }
                    16 -> {
                        //제주 연결
                        val jeJuIntent = Intent(activity, SeoulActivity::class.java)
                        jeJuIntent.putExtra("code", 17)
                        startActivity(jeJuIntent)
                    }
                }
            }
        }
        recyclerView.adapter = adapter
    }


    private fun dataInitialize() {
        areaArrayList = arrayListOf<Model>()

        imageId = arrayOf(
            R.drawable.seoulimage,
            R.drawable.seoulimage2,
            R.drawable.seoulimage3,
            R.drawable.seoulimage4,
            R.drawable.seoulimage5,
            R.drawable.seoulimage,
            R.drawable.seoulimage2,
            R.drawable.seoulimage3,
            R.drawable.seoulimage4,
            R.drawable.seoulimage5,
            R.drawable.seoulimage,
            R.drawable.seoulimage2,
            R.drawable.seoulimage3,
            R.drawable.seoulimage4,
            R.drawable.seoulimage5,
            R.drawable.seoulimage,
            R.drawable.seoulimage2
        )
        titleId = arrayOf(
            getString(R.string.서울),
            getString(R.string.인천),
            getString(R.string.대전),
            getString(R.string.대구),
            getString(R.string.광주),
            getString(R.string.부산),
            getString(R.string.울산),
            getString(R.string.세종특별자치시),
            getString(R.string.경기도),
            getString(R.string.강원특별자치도),
            getString(R.string.충청북도),
            getString(R.string.충청남도),
            getString(R.string.경상북도),
            getString(R.string.경상남도),
            getString(R.string.전라북도),
            getString(R.string.전라남도),
            getString(R.string.제주)
        )
        desId = arrayOf(
            getString(R.string.서울소개),
            getString(R.string.인천소개),
            getString(R.string.대전소개),
            getString(R.string.대구소개),
            getString(R.string.광주소개),
            getString(R.string.부산소개),
            getString(R.string.울산소개),
            getString(R.string.세종특별자치시소개),
            getString(R.string.경기도소개),
            getString(R.string.강원특별자치도소개),
            getString(R.string.충청북도소개),
            getString(R.string.충청남도소개),
            getString(R.string.경상북도소개),
            getString(R.string.경상남도소개),
            getString(R.string.전라북도소개),
            getString(R.string.전라남도소개),
            getString(R.string.제주소개)
        )

        for(i in titleId.indices) {
            val areas = Model(titleId[i],desId[i], imageId[i])
            areaArrayList.add(areas)
        }
    }

}