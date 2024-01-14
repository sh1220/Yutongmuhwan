package com.example.a2023_1_2_yutongmuhwan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.a2023_1_2_yutongmuhwan.databinding.FragmentProductSelectBinding

class ProductRegistrationFoodFragment: Fragment() {
    lateinit var binding: FragmentProductSelectBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductSelectBinding.inflate(inflater, container, false)

        binding.myTv.text = "상품등록>" + arguments?.getString("key_message")

        binding.myTv.setTextColor( ContextCompat.getColor(requireContext(), R.color.blue_thick3))

        binding.buttonVegetableTv.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.blue_thick2)
        binding.buttonFruitTv.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.blue_thick2)
        binding.buttonMeatTv.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.blue_thick2)
        binding.buttonSeafoodTv.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.blue_thick2)
        binding.buttonDairyProductTv.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.blue_thick2)
        binding.buttonDrinkTv.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.blue_thick2)
        binding.buttonEtcTv.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.blue_thick2)


        binding.buttonVegetableTv.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm,ProductRegistrationDetail())
                .addToBackStack(null)
                .commit()
        }

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