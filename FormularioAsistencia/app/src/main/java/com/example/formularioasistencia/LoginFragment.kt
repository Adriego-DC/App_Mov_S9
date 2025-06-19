package com.example.formularioasistencia

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.formularioasistencia.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var db: UserDatabaseHelper

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentLoginBinding.bind(view)
        db = UserDatabaseHelper(requireContext())

        binding.tvRegistrar.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.etUsuario.text.toString().trim()
            val pass = binding.etContrasena.text.toString().trim()

            val user = db.obtenerUsuario(email, pass)
            if (user != null) {
                // Guardar el correo en SharedPreferences para uso posterior (por ejemplo en Perfil)
                val sharedPref = requireActivity().getSharedPreferences("datos_usuario", Context.MODE_PRIVATE)
                sharedPref.edit().putString("correo", email).apply()

                when (user.tipoUsuario) {
                    "Alumno" -> {
                        startActivity(Intent(requireContext(), HomeAlumnoActivity::class.java))
                    }
                    "Docente" -> {
                        startActivity(Intent(requireContext(), HomeDocenteActivity::class.java))
                    }
                    else -> {
                        Toast.makeText(requireContext(), "Tipo de usuario desconocido", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(requireContext(), "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
