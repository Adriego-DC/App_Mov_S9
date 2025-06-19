package com.example.formularioasistencia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.formularioasistencia.databinding.ActivityHomeDocenteBinding

class HomeDocenteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeDocenteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeDocenteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Cargar Home por defecto
        loadFragment(HomeDocenteFragment())
        binding.tvTitulo.text = "Home Docente"
        binding.bottomNavigationView.selectedItemId = R.id.menu_nav

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_nav -> {
                    loadFragment(HomeDocenteFragment())
                    binding.tvTitulo.text = "Home Docente"
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
