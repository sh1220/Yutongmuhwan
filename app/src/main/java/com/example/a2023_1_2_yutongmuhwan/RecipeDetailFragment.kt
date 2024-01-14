package com.example.a2023_1_2_yutongmuhwan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.example.a2023_1_2_yutongmuhwan.databinding.FragmentProductSelectBinding
import com.example.a2023_1_2_yutongmuhwan.databinding.FragmentRecipeDetailBinding

class RecipeDetailFragment : Fragment() {
    lateinit var binding: FragmentRecipeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecipeDetailBinding.inflate(inflater, container, false)

        when (arguments?.getInt("key_message")) {
            2 -> {
                binding.recipeNameTv.text = "삼겹살 김치볶음"
                binding.recipeIngredientDetail1Tv.text = "· 묵은지 400g\n" +
                        "· 삼겹살 300g\n" +
                        "· 대파 1대 양파 "
                binding.recipeIngredientDetail2Tv.text =
                    "· 청주2t\n" +
                            "· 다진마늘1/2t\n" +
                            "· 매실청 2t\n" +
                            "· 고추가루 2t\n" +
                            "· 들기름 2t"
                binding.recipeCookingOrderDetailTv.text =
                    "1.삼겹살을 중불로 익혀주세요.\n" +
                            "2.다진마늘 반스푼 청주 2스푼을 넣어주세요.\n" +
                            "3. 대파를 넣고 볶아주세요.\n" +
                            "4. 김치를 넣고 함께 볶아주세요.\n" +
                            "5.고추가루 매실청 들기름 2 스푼을 넣어주세요.\n" +
                            "6. 약불로 김치가 투명해 질 때까지 천천히 볶아주세요."
            }

            3 -> {
                binding.recipeNameTv.text = "돼지 짜글이"
                binding.recipeIngredientDetail1Tv.text = "· 돼지고기200g\n· 감자1개\n· 양파1/2개\n· 대파1/4개"
                binding.recipeIngredientDetail2Tv.text =
                    "· 다시마육수(물로 대체 가능)1컵\n· 맛술2큰술,식용유약간\n· 고춧가루1/2큰술\n· 고추장1/2큰술\n· 간장3스푼\n· 멸치액젓1스푼\n" +
                            "· 쯔유는 취향따라\n" +
                            "· 다진마늘1스푼"
                binding.recipeCookingOrderDetailTv.text =
                    "1. 물과 돼지고기 비율은 2:1 로 하고 물이 끓으면 돼지고기를 넣어주세요 !\n" +
                            "2. 돼지고기 넣고 다시한번 물이 끓을때 고추장2스푼, 고춧가루2스푼, 다진마늘1스푼 넣어주시고 다시한번 끓여주세요\n" +
                            "3. 양념장 넣고 양파 1/2개 슬라이스 해서 넣어주고 대파도 썰어넣고 다시한번 끓여주세요\n" +
                            "4. 이때 간장 3스푼, 멸치액젓 1스푼, 쯔유 1스푼을 넣어주시고 끓여주세요\n" +
                            "5. 한번 더 끓어오르면 묵은지를 넣어주세요.\n" +
                            "6. 설탕 0.5스푼 추가로 넣어주세요"
            }
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