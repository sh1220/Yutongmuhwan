package com.example.a2023_1_2_yutongmuhwan

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.example.a2023_1_2_yutongmuhwan.data.Food
import com.example.a2023_1_2_yutongmuhwan.data.FoodDatabase
import com.example.a2023_1_2_yutongmuhwan.databinding.FragmentProductRegistorationDetailBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class ProductRegistrationDetail: Fragment() {
    lateinit var binding: FragmentProductRegistorationDetailBinding

    private lateinit var editTextPurchaseDate: EditText
    private lateinit var editTextExpirationDate: EditText
    private var purcahse_month: Int? = null
    private var purcahse_day: Int? = null
    private var expiration_month: Int? = null
    private var expiration_day: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductRegistorationDetailBinding.inflate(inflater, container, false)



        editTextPurchaseDate = binding.foodPurchaseDateEd
        editTextExpirationDate = binding.foodExpirationDateEd

        // EditText를 클릭하면 DatePickerDialog를 표시
        editTextPurchaseDate.setOnClickListener {
            showPurchaseDatePickerDialog()
        }
        editTextExpirationDate.setOnClickListener {
            showExpirationDatePickerDialog()
        }


        binding.buttonRegistrationTv.setOnClickListener {
            if (binding.foodNameEd != null && purcahse_month != null && purcahse_day != null && expiration_month != null && expiration_day != null)
            {
                val foodDb = FoodDatabase.getInstance(requireContext())
                foodDb!!.foodDao(). insert(Food(binding.foodNameEd.text.toString(), purcahse_month!!, purcahse_day!!, expiration_month!!, expiration_day!!))
                parentFragmentManager.popBackStack()
                parentFragmentManager.popBackStack()
                parentFragmentManager.popBackStack()

            }
            else
            {
                Toast.makeText(context, "정보를 입력해주세요.", Toast.LENGTH_SHORT).show()
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

    private fun showPurchaseDatePickerDialog() {
        val currentDate = Calendar.getInstance()
        val year = currentDate.get(Calendar.YEAR)
        val month = currentDate.get(Calendar.MONTH)
        val day = currentDate.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            DatePickerDialog.OnDateSetListener { view: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                // 선택된 날짜를 EditText에 설정
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, month, dayOfMonth)

                val dateFormat = SimpleDateFormat("yyyy년 MM월 dd일", Locale.getDefault())
                val formattedDate = dateFormat.format(selectedDate.time)

                purcahse_month = month
                purcahse_day = dayOfMonth

                editTextPurchaseDate.setText(formattedDate)
            },
            year,
            month,
            day
        )

        // 현재 날짜를 최대 날짜로 설정
        datePickerDialog.datePicker.maxDate = System.currentTimeMillis()

        datePickerDialog.show()
    }


    private fun showExpirationDatePickerDialog() {
        val currentDate = Calendar.getInstance()
        val year = currentDate.get(Calendar.YEAR)
        val month = currentDate.get(Calendar.MONTH)
        val day = currentDate.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            DatePickerDialog.OnDateSetListener { view: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                // 선택된 날짜를 EditText에 설정
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, month, dayOfMonth)

                val dateFormat = SimpleDateFormat("yyyy년 MM월 dd일", Locale.getDefault())
                val formattedDate = dateFormat.format(selectedDate.time)

                expiration_month = month
                expiration_day = dayOfMonth

                editTextExpirationDate.setText(formattedDate)
            },
            year,
            month,
            day
        )

        // 현재 날짜를 최소 날짜로 설정
        datePickerDialog.datePicker.minDate = System.currentTimeMillis()

        datePickerDialog.show()
    }

}