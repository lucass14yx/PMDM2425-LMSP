package conexion

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class AdminSQLIteConexion(context: Context, name: String, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {
    //Si hay algún cambio en la BBDD, se cambia el número de versión y así automáticamente
    companion object {
        val DATABASE_VERSION: Int = 1
        val DATABASE_NAME: String = "administracion.db3"
    }

    constructor(context: Context): this(context, DATABASE_NAME, null, DATABASE_VERSION){
    }

    override fun onCreate(db: SQLiteDatabase) {
        Log.e("SQLLite","Paso por onCreate del AdminSQLIteConexion")
        /*
        Este método se lanza automáticamente cuando se ejecuta SQLite por primera vez (función sobrrescrita ya que es obigatoria)
        Aquí crearíamos las tablas y claves si son más de una.
        Se crean la primera vez si no existe. Pero tener en cuenta que aquí se guardarán configuraciones
        y pequeñas cosas, por lo tanto tampoco se metarán grandes sentencias yq que SQLite no está pensado para eso
        Para BBDD más complejas, ya usarmeos servicios externos.
        */
        db.execSQL("create table persona(dni text primary key, nombre text, edad int)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        Log.e("SQLLite","Paso por OnUpgrade del AdminSQLIteConexion")
        //si la BBDD ya existe, se modificaria con el SQL que aquí pongamos.
        //Si no existe se va al OnCreate, si existe, viene aquí.
        //para venir aquí has tenido que pasar una versión diferente y se detecta automáticamente y pasa por aquí.
        //por ejemplo podríamos borrar una tabla con DROP y luego crearla si interesa que una tabla esté siempre vacía
        //o le hago un truncate y me cargo sus datos directamente. (por ejemplo la típica tabla de registro de bitácora de la sesión)
    }
}