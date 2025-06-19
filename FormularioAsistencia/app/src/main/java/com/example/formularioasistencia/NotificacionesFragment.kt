package com.example.formularioasistencia

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class NotificacionesFragment : Fragment(R.layout.fragment_notificaciones) {

    private lateinit var recyclerView: RecyclerView
    private val listaNotificaciones = listOf("Confirmación de asistencia al desfile")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById(R.id.recyclerEspecialidades)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = NotificacionAdapter(listaNotificaciones) { mostrarDialog() }
    }

    private fun mostrarDialog() {
        val dialogView = LayoutInflater.from(requireContext())
            .inflate(R.layout.dialog_notificacion, null)

        val builder = AlertDialog.Builder(requireContext())
            .setView(dialogView)

        val dialog = builder.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val btnRegistrar = dialogView.findViewById<Button>(R.id.btnDialogRegistrar)
        btnRegistrar.setOnClickListener {
            Toast.makeText(requireContext(), "Registrado en el desfile", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        val tvMasInfo = dialogView.findViewById<TextView>(R.id.tvMasInformacion)
        tvMasInfo.setOnClickListener {
            dialog.dismiss()
            val intent = Intent(requireContext(), WebViewActivity::class.java)
            startActivity(intent)
        }

        dialog.show()
    }
}
