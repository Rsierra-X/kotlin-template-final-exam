package com.test.template_final_exam.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.template_final_exam.R
import com.test.template_final_exam.databinding.FragmentInsertBinding

class InsertFragment : Fragment() {

    lateinit var binding : FragmentInsertBinding;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInsertBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

}