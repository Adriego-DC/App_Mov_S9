package com.example.formularioasistencia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class ExitoFragment : Fragment(R.layout.fragment_exito) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val botonAceptar = view.findViewById<Button>(R.id.btnAceptar)
        botonAceptar.setOnClickListener {
            findNavController().navigate(R.id.action_exitoFragment_to_loginFragment)
        }
    }
}
