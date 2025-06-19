package com.example.formularioasistencia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.formularioasistencia.databinding.ActivityHomeAlumnoBinding

class HomeAlumnoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeAlumnoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeAlumnoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Cargar Home por defecto
        loadFragment(HomeAlumnoFragment())
        binding.tvTitulo.text = "Home Alumno"
        binding.bottomNavigationView.selectedItemId = R.id.menu_nav

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_nav -> {
                    loadFragment(HomeAlumnoFragment())
                    binding.tvTitulo.text = "Home Alumno"
                    true
                }
                R.id.notificaciones_nav -> {
                    loadFragment(NotificacionesFragment())
                    binding.tvTitulo.text = "Notificaciones"
                    true
                }
                R.id.perfil_nav -> {
                    loadFragment(PerfilFragment())
                    binding.tvTitulo.text = "Perfil"
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameContainer, fragment)
            .commit()
    }
}
