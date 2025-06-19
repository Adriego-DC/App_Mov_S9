package com.example.formularioasistencia

data class User(
    val correo: String,
    val contrasena: String,
    val nombre: String,
    val apellido: String,
    val telefono: String,
    val tipoUsuario: String,  // Alumno o Docente
    val codigo: String        // Código único
)
