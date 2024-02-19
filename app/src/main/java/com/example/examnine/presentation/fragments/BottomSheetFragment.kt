package com.example.examnine.presentation.fragments

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.*
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.examnine.R
import com.example.examnine.databinding.FragmentBottomSheetBinding
import com.example.examnine.presentation.base.BaseFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.DialogFragment

@AndroidEntryPoint
class BottomSheetFragment : BottomSheetDialogFragment() {


    interface BottomSheetListener {
        fun onOptionClicked(option: String)

    }
    private var _binding: FragmentBottomSheetBinding? = null
    private val binding get() = _binding!!
    private var bottomSheetListener: BottomSheetListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listeners()
    }

    private fun listeners(){
        binding.tvChoosePicture.setOnClickListener {
            bottomSheetListener?.onOptionClicked("Choose Picture")
            dismiss()
        }
        binding.tvTakePicture.setOnClickListener {
            bottomSheetListener?.onOptionClicked("Take Picture")
            dismiss()
        }
    }

    fun setBottomSheetListener(listener: BottomSheetListener) {
        bottomSheetListener = listener
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}