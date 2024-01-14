package com.example.a2023_1_2_yutongmuhwan

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.a2023_1_2_yutongmuhwan.data.Food
import com.example.a2023_1_2_yutongmuhwan.data.FoodDatabase
import com.example.a2023_1_2_yutongmuhwan.data.PurchaseFragment
import com.example.a2023_1_2_yutongmuhwan.databinding.FragmentListBinding


class ListFragment : Fragment() {

    lateinit var binding: FragmentListBinding
    var foodList: ArrayList<Food> = ArrayList()
    var listAdapter: ListAdapter? = null
    var foodDBInitial = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListBinding.inflate(inflater, container, false)


        val foodDao = FoodDatabase.getInstance((requireContext()))!!.foodDao()



        if(foodDBInitial == false){
            foodList.addAll(foodDao.getFoods())
            foodDBInitial = true
        }
            listAdapter =ListAdapter(foodList)

            listAdapter!!.setOnImgClickListener(object :
                ListAdapter.OnImgClickListener {
                override fun onImgClickListener() {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.main_frm,PurchaseFragment())
                        .addToBackStack(null)
                        .commit()
                }
            })


            binding.foodListRv.adapter = listAdapter
            binding.foodListRv.layoutManager = LinearLayoutManager(context)




        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (parentFragmentManager.backStackEntryCount > 0) {
                    parentFragmentManager.popBackStack()
                } else {
                    isEnabled = false
                    requireActivity().onBackPressed()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)



        return binding.root
    }
}
