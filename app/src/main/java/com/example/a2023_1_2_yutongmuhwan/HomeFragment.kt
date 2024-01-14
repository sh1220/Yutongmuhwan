package com.example.a2023_1_2_yutongmuhwan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a2023_1_2_yutongmuhwan.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.buttonRefrigeratorTv.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm,RefrigeratorFragment())
                .addToBackStack(null)
                .commit()

        }

        binding.buttonProductRegistrationTv.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm,ProductRegistrationWhereFragment())
                .addToBackStack(null)
                .commit()

        }

        return binding.root
    }
}