package com.test.template_final_exam.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jalfaro.semana12.interfaces.MascotaClickListener
import com.test.template_final_exam.actualizarMascotaDialog
import com.test.template_final_exam.adapter.MascotaAdapter
import com.test.template_final_exam.database.entities.Mascota
import com.test.template_final_exam.databinding.FragmentSelectBinding
import com.test.template_final_exam.editaMascotaDialog
import com.test.template_final_exam.viewModel.SelectViewModel


class SelectFragment : Fragment(), MascotaClickListener {
    lateinit var binding: FragmentSelectBinding
    lateinit var viewModel: SelectViewModel
    val adapter = MascotaAdapter(arrayListOf(), this)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(SelectViewModel::class.java)
        binding.rvMascotas.adapter = adapter
        binding.rvMascotas.layoutManager = LinearLayoutManager(context)
        viewModel.mascotas.observe(viewLifecycleOwner) { newList ->
            Log.d("TEST", "${newList.size}")
            adapter.loadNewItems(newList)
        }
        viewModel.loadMascotas()
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onClick(mascota: Mascota) {
        context?.let { ctx ->
            actualizarMascotaDialog(ctx,
                mascota,
                { mascota ->
                    editaMascotaDialog(ctx, mascota) { pet ->
                        viewModel.updateMascota(pet, adapter)
                    }
                },
                { mascota ->
                    viewModel.deleteMascota(mascota, adapter)
                })
        }
    }
}