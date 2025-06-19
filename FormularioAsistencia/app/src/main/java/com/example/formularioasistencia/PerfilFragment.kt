package com.example.formularioasistencia

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.formularioasistencia.databinding.FragmentPerfilBinding

class PerfilFragment : Fragment(R.layout.fragment_perfil) {

    private lateinit var binding: FragmentPerfilBinding
    private lateinit var db: UserDatabaseHelper

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentPerfilBinding.bind(view)
        db = UserDatabaseHelper(requireContext())

        // Obtener el correo guardado al iniciar sesión
        val sharedPref = requireActivity().getSharedPreferences("datos_usuario", 0)
        val correo = sharedPref.getString("correo", null)

        correo?.let { correoGuardado ->
            val user = db.obtenerUsuarioPorCorreo(correoGuardado)
            user?.let { usuario ->
                // Asignar datos al perfil
                binding.tvNombre.text = usuario.nombre
                binding.tvApellido.text = usuario.apellido
                binding.tvCorreo.text = usuario.correo
                binding.tvTelefono.text = usuario.telefono
                binding.tvCodigo.text = usuario.codigo

                // Cambiar imagen según tipo de usuario
                if (usuario.tipoUsuario == "Docente") {
                    binding.imgPerfil.setImageResource(R.drawable.perfil_docente)
                } else if (usuario.tipoUsuario == "Alumno") {
                    binding.imgPerfil.setImageResource(R.drawable.perfil_alumno)
                }
            }
        }

    }
}
