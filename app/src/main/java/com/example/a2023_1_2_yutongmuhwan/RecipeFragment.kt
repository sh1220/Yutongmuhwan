package com.example.a2023_1_2_yutongmuhwan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.a2023_1_2_yutongmuhwan.databinding.FragmentRecipeBinding

class RecipeFragment : Fragment() {
    lateinit var binding: FragmentRecipeBinding
    private var difficult : Int? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecipeBinding.inflate(inflater, container, false)


        binding.difficult1Mcv.setOnClickListener {
            binding.difficult1Mcv.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.blue_thick2))
            binding.difficult2Mcv.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
            binding.difficult3Mcv.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
            difficult = 1
        }

        binding.difficult2Mcv.setOnClickListener {
            binding.difficult1Mcv.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
            binding.difficult2Mcv.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.blue_thick2))
            binding.difficult3Mcv.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
            difficult = 2
        }

        binding.difficult3Mcv.setOnClickListener {
            binding.difficult1Mcv.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
            binding.difficult2Mcv.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
            binding.difficult3Mcv.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.blue_thick2))
            difficult = 3
        }

        binding.btnRecipeGoMcv.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("key_message", difficult!!)

            val receiverFragment = RecipeDetailFragment()
            receiverFragment.arguments = bundle

            parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm, receiverFragment)
                .addToBackStack(null)
                .commit()
        }


        return binding.root
    }
}