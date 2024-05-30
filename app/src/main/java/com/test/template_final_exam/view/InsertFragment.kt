package com.test.template_final_exam.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.test.template_final_exam.R
import com.test.template_final_exam.database.entities.Mascota
import com.test.template_final_exam.databinding.FragmentInsertBinding
import com.test.template_final_exam.viewModel.InsertViewModel

class InsertFragment : Fragment() {

    lateinit var binding : FragmentInsertBinding;
    lateinit var viewModel: InsertViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInsertBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(InsertViewModel::class.java)
        binding.btnGrabar.setOnClickListener {
            val mascota = Mascota(
                nombre = binding.nombre.text.toString(),
                raza = binding.raza.text.toString(),
                dueno = binding.dueno.text.toString()
            )
            binding.raza.text.clear()
            binding.dueno.text.clear()
            binding.nombre.text.clear()
            viewModel.save(mascota)
        }
        binding.btnListado.setOnClickListener {
            findNavController().navigate(R.id.action_insertFragment_to_selectFragment)
        }
        // Inflate the layout for this fragment
        return binding.root
    }

}