package com.example.a2023_1_2_yutongmuhwan

import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.a2023_1_2_yutongmuhwan.data.Food
import com.example.a2023_1_2_yutongmuhwan.data.FoodDatabase
import com.example.a2023_1_2_yutongmuhwan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var exit_millis : Long = 0
    var foodDBInitial = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigation()



        // 싱글톤 패턴을 사용하지 않은 경우
        val foodDb = FoodDatabase.getInstance(this)


        if (foodDBInitial == false)
        {
            foodDb!!.foodDao().deleteAll()
            with(foodDb!!.foodDao()) {
                insert(Food("배추", 10, 10, 10, 20))
                insert(Food("무", 10, 10, 10, 20))
                insert(Food("고추", 10, 11, 10, 21))
                insert(Food("팽이버섯", 10, 11, 10, 21))
            }

            foodDBInitial = true
        }





    }

    private fun initBottomNavigation() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, HomeFragment())
            .commitAllowingStateLoss()
        binding.mainBnv.selectedItemId = R.id.homeFragment


        binding.mainBnv.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment -> {
                    binding.appbarTv.text = "유통무환"
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.drinkSearchFragment -> {
                    binding.appbarTv.text = "레시피 추천"
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, RecipeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.myFragment -> {
                    binding.appbarTv.text = "마이페이지"
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, MyFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

            }
            false
        }
        binding.mainBnv.itemIconTintList = null


        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val fragment = supportFragmentManager.findFragmentById(R.id.main_frm)
                if (fragment is HomeFragment) {
                    killApp()
                } else {
                    binding.mainBnv.selectedItemId = R.id.homeFragment
                }
            }
        }
        onBackPressedDispatcher.addCallback(this, callback)









    }


    fun killApp() {
        if (System.currentTimeMillis() - exit_millis > 2000) {
            exit_millis = System.currentTimeMillis()
            Toast.makeText(this, "'뒤로' 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show()
        } else {
            finish()
        }


    }



}