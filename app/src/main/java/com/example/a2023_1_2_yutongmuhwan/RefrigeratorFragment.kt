package com.example.a2023_1_2_yutongmuhwan

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a2023_1_2_yutongmuhwan.databinding.FragmentProductSelectBinding

class RefrigeratorFragment : Fragment() {
    lateinit var binding: FragmentProductSelectBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductSelectBinding.inflate(inflater, container, false)


        binding.buttonVegetableTv.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm,ListFragment())
                .addToBackStack(null)
                .commit()


        }



        return binding.root
    }
}