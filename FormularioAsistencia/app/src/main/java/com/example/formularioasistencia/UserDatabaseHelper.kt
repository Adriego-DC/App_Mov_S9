package com.example.formularioasistencia

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class UserDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "usuarios.db"
        const val DATABASE_VERSION = 1
        const val TABLE_USER = "usuarios"
        const val COLUMN_EMAIL = "email"
        const val COLUMN_PASSWORD = "password"
        const val COLUMN_NOMBRE = "nombre"
        const val COLUMN_APELLIDO = "apellido"
        const val COLUMN_TELEFONO = "telefono"
        const val COLUMN_TIPO = "tipoUsuario"
        const val COLUMN_CODIGO = "codigo"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = """
            CREATE TABLE $TABLE_USER (
                $COLUMN_EMAIL TEXT PRIMARY KEY,
                $COLUMN_PASSWORD TEXT,
                $COLUMN_NOMBRE TEXT,
                $COLUMN_APELLIDO TEXT,
                $COLUMN_TELEFONO TEXT,
                $COLUMN_TIPO TEXT,
                $COLUMN_CODIGO TEXT
            )
        """.trimIndent()
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_USER")
        onCreate(db)
    }

    fun insertarUsuario(user: User): Boolean {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_EMAIL, user.correo)
            put(COLUMN_PASSWORD, user.contrasena)
            put(COLUMN_NOMBRE, user.nombre)
            put(COLUMN_APELLIDO, user.apellido)
            put(COLUMN_TELEFONO, user.telefono)
            put(COLUMN_TIPO, user.tipoUsuario)
            put(COLUMN_CODIGO, user.codigo)
        }
        val result = db.insert(TABLE_USER, null, values)
        db.close()
        return result != -1L
    }

    fun obtenerUsuario(email: String, password: String): User? {
        val db = readableDatabase
        val cursor = db.rawQuery(
            "SELECT * FROM $TABLE_USER WHERE $COLUMN_EMAIL = ? AND $COLUMN_PASSWORD = ?",
            arrayOf(email, password)
        )

        var user: User? = null
        if (cursor.moveToFirst()) {
            user = User(
                correo = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EMAIL)),
                contrasena = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PASSWORD)),
                nombre = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOMBRE)),
                apellido = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_APELLIDO)),
                telefono = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TELEFONO)),
                tipoUsuario = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TIPO)),
                codigo = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CODIGO))
            )
        }
        cursor.close()
        db.close()
        return user
    }
    fun obtenerUsuarioPorCorreo(email: String): User? {
        val db = readableDatabase
        val cursor = db.rawQuery(
            "SELECT * FROM $TABLE_USER WHERE $COLUMN_EMAIL = ?",
            arrayOf(email)
        )

        var user: User? = null
        if (cursor.moveToFirst()) {
            user = User(
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EMAIL)),
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PASSWORD)),
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOMBRE)),
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_APELLIDO)),
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TELEFONO)),
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TIPO)),
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CODIGO))
            )
        }
        cursor.close()
        db.close()
        return user
    }

}
