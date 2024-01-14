package com.example.a2023_1_2_yutongmuhwan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.example.a2023_1_2_yutongmuhwan.databinding.FragmentProductRegistorationWhereBinding

class ProductRegistrationWhereFragment: Fragment() {
    lateinit var binding: FragmentProductRegistorationWhereBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductRegistorationWhereBinding.inflate(inflater, container, false)

        binding.buttonRefrigeratorTv.setOnClickListener {

            val bundle = Bundle()
            bundle.putString("key_message", "냉장고")

            val receiverFragment = ProductRegistrationFoodFragment()
            receiverFragment.arguments = bundle

            parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm, receiverFragment)
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