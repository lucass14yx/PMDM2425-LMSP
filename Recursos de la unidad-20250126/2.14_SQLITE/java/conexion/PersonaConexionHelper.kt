package conexion

import modelo.Persona
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

object PersonaConexionHelper {

    fun addPersona(contexto: AppCompatActivity, p: Persona):Long{
        val admin = AdminSQLIteConexion(contexto)
        val bd: SQLiteDatabase = admin.writableDatabase //habilito la BBDD para escribir en ella, también deja leer.
        val registro = ContentValues() //objeto de kotlin, contenido de valores, un Map.
        registro.put("dni", p.dni)
        registro.put("nombre",p.nombre)
        registro.put("edad", p.edad.toString())
        val returnData = bd.insert("persona", null, registro)
        bd.close()
        return returnData
    }

    fun delPersona(contexto: AppCompatActivity, dni: String):Int{
        val admin = AdminSQLIteConexion(contexto)
        val bd: SQLiteDatabase = admin.writableDatabase
        //val cant = bd.delete("persona", "dni='${dni}'", null)
        val cant = bd.delete("persona", "dni=?", arrayOf(dni.toString()))
        bd.close()
        return cant
    }

    fun modPersona(contexto:AppCompatActivity, dni:String, p:Persona):Int {
        val admin = AdminSQLIteConexion(contexto)
        val bd: SQLiteDatabase = admin.writableDatabase
        val registro = ContentValues()
        registro.put("nombre", p.nombre)
        registro.put("edad", p.edad)
       // val cant = bd.update("persona", registro, "dni='${dni}'", null)
        val cant = bd.update("persona", registro, "dni=?", arrayOf(dni.toString()))
        //val cant = bd.update("personas", registro, "dni=? AND activo=?", arrayOf(dni.toString(), activo.toString()))
        //Esta línea de más arriba es para tener un ejemplo si el where tuviese más condiciones
        //es mejor la forma de la línea 39 que la de la línea 38, ya que es peligroso inyectar sql directamente
        bd.close()
        return cant
    }

    fun buscarPersona(contexto: AppCompatActivity, dni:String):Persona? {
        var p:Persona? = null //si no encuentra ninguno vendrá null, por eso la ? y también en la devolución de la función.
        val admin = AdminSQLIteConexion(contexto)
        val bd: SQLiteDatabase = admin.readableDatabase
        /*Esta funciona pero es mejor como está hecho justo debajo con ?
        val fila = bd.rawQuery(
            "select nombre,edad from personas where dni='${dni}'",
            null
        )*/
        val fila =bd.rawQuery(
            "SELECT nombre, edad FROM persona WHERE dni=?",
            arrayOf(dni.toString())
        )
        //en fila es un CURSOR con el ResultSet
        if (fila.moveToFirst()) {//si no hay datos el moveToFirst, devuelve false, si hay devuelve true.
            p = Persona(dni, fila.getString(0), fila.getInt(1))
        }
        bd.close()
        return p
    }

    fun obtenerPersonas(contexto: AppCompatActivity):ArrayList<Persona>{
        var personas:ArrayList<Persona> = ArrayList(1)

        val admin = AdminSQLIteConexion(contexto)
        val bd: SQLiteDatabase = admin.readableDatabase
        val fila = bd.rawQuery("select dni,nombre,edad from persona", null)
        while (fila.moveToNext()) {
            var p:Persona = Persona(fila.getString(0),fila.getString(1),fila.getInt(2))
            personas.add(p)
        }
        bd.close()
        return personas //este arrayList lo puedo poner en un adapter de un RecyclerView por ejemplo.
    }

}