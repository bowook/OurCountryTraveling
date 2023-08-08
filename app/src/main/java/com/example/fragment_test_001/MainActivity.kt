package com.example.fragment_test_001

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.KeyEvent
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.fragment_test_001.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //gridView 참조 추가
    private lateinit var sixGridView: GridView
    private lateinit var fiveGridView: GridView

    private val firstImages = intArrayOf(R.drawable.testbadge,R.drawable.testbadge,R.drawable.testbadge,R.drawable.testbadge,R.drawable.testbadge,R.drawable.testbadge,
            R.drawable.testbadge,R.drawable.testbadge,R.drawable.testbadge,R.drawable.testbadge,R.drawable.testbadge,R.drawable.testbadge)
    private val secondImages = intArrayOf(R.drawable.testbadge,R.drawable.testbadge,R.drawable.testbadge,R.drawable.testbadge,R.drawable.testbadge)

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val sliderImageHandler: Handler = Handler(Looper.getMainLooper())
    private val sliderImageRunnable = Runnable {
        val nextItem = if (binding.viewPager.currentItem +1 == binding.viewPager.adapter?.itemCount) {
            0
        } else {
            binding.viewPager.currentItem + 1
        }
        binding.viewPager.currentItem = nextItem
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //뱃지 연결
        sixGridView = binding.badgeGridViewSix
        sixGridView.adapter = ImageAdapter(this, firstImages)
        fiveGridView = binding.badgeGridViewFive
        fiveGridView.adapter = ImageAdapter(this,secondImages)

        //백스택 관리, 이전 페이지가 남아있다 라는건 메인화면이 아니란 소리임
        //따라서 메인화면일 경우에 drawer tab을 unlock 시켜서 사용할 수 있게함
        //백스택이 있을 경우는 메인화면이 아니란 소리니까 lock
        supportFragmentManager.addOnBackStackChangedListener {
            val backStackEntryCount = supportFragmentManager.backStackEntryCount
            if(backStackEntryCount > 0) {
                binding.dlMain.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            }
            else  {
                binding.dlMain.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            }
        }

        /* 여백, 너비에 대한 정의 */
        //뷰페이저 시작
        val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.pageMargin) // dimen 파일 안에 크기를 정의함 꼬군빨
        val pagerWidth = resources.getDimensionPixelOffset(R.dimen.pageWidth)
        val screenWidth = resources.displayMetrics.widthPixels // 스마트폰의 너비 길이를 가져옴
        val offsetPx = screenWidth - pageMarginPx - pagerWidth

        binding.viewPager.apply {
            adapter = ViewPagerAdapter(getTourList(), binding.viewPager)
            offscreenPageLimit = 1 //미리보기 이미지 1장
            getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    //첫번째 이미지로 돌아갔을 때 대기 시간
                    val waitTime = if (position >= 2) {
                        500L
                    } else {
                        3000L
                    }
                    sliderImageHandler.removeCallbacks(sliderImageRunnable)
                    sliderImageHandler.postDelayed(sliderImageRunnable, waitTime)
                }
            })
            setPageTransformer { page, position ->
                page.translationX = position * -offsetPx
            }
        }

        binding.run {
            fragment2Btn.setOnClickListener {
                replaceFragment(Fragment2())
            }
            menuTab.setOnClickListener {
                dlMain.openDrawer(GravityCompat.END)
            }
        }
    }
    override fun onResume() {
        super.onResume()
        sliderImageHandler.postDelayed(sliderImageRunnable,500)
    }
    //뷰페이저에 이미지 추가
    private fun getTourList(): ArrayList<Int> {
        return arrayListOf(R.drawable.viewtest, R.drawable.testbadge, R.drawable.ic_launcher_background)
    }
    private fun replaceFragment(homeFragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, homeFragment)
        fragmentTransaction.addToBackStack("")
        fragmentTransaction.setReorderingAllowed(true)
        fragmentTransaction.commit()
        onPause()
    }
     //안드로이드에서 제공하는 onKeyDown 재정의 하려고 사용함 override로
     //뒤로가기 눌렀을때 처리임

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (binding.dlMain.isDrawerOpen(GravityCompat.END)) {
                //이건 drawer이 열려있을 때 뒤로가기 누르면 사라지게하는거
                binding.dlMain.closeDrawer(GravityCompat.END)
                return true
            }
            //이곳에 한번 더 누르면 꺼지게 코드 추가 하면 됨.
        }
        return super.onKeyDown(keyCode, event)
    }
}

//뱃지 연결할 때 사용한 이미지 어댑터
class ImageAdapter(private val context: Context, private val imageIds: IntArray) : BaseAdapter() {

    override fun getCount(): Int {
        return imageIds.size
    }

    override fun getItem(position: Int): Any {
        return imageIds[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val imageView: ImageView
        if (convertView == null) {
            imageView = ImageView(context)
            imageView.layoutParams = ViewGroup.LayoutParams(150, 150)
            imageView.scaleType = ImageView.ScaleType.FIT_XY
        } else {
            imageView = convertView as ImageView
        }
        imageView.setImageResource(imageIds[position])

        return imageView
    }
}
