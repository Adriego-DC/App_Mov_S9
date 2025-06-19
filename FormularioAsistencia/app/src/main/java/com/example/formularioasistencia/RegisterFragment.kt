package com.example.formularioasistencia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.formularioasistencia.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var binding: FragmentRegisterBinding
    private lateinit var db: UserDatabaseHelper

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterBinding.bind(view)
        db = UserDatabaseHelper(requireContext())

        // Llenar el Spinner con opciones
        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.tipo_usuario_array, // Este array debe estar en res/values/strings.xml
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerTipoUsuario.adapter = adapter

        binding.btnRegistrar.setOnClickListener {
            val correo = binding.etCorreo.text.toString().trim()
            val pass = binding.etContrasena.text.toString().trim()
            val nombre = binding.etNombre.text.toString().trim()
            val apellido = binding.etApellido.text.toString().trim()
            val telefono = binding.etTelefono.text.toString().trim()
            val tipoUsuario = binding.spinnerTipoUsuario.selectedItem.toString()
            val codigo = binding.etCodigo.text.toString().trim()

            if (!Validators.isValidEmail(correo)) {
                Toast.makeText(requireContext(), "Correo no válido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!Validators.isValidPhone(telefono)) {
                Toast.makeText(requireContext(), "Teléfono no válido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (codigo.isEmpty()) {
                Toast.makeText(requireContext(), "Ingrese el código", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val user = User(correo, pass, nombre, apellido, telefono, tipoUsuario, codigo)
            if (db.insertarUsuario(user)) {
                findNavController().navigate(R.id.action_registerFragment_to_exitoFragment)
            } else {
                Toast.makeText(requireContext(), "Error al registrar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
