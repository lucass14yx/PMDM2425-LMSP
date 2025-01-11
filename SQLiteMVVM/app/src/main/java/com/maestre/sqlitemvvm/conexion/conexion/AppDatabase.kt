package com.examen.sqlitemvvm.com.maestre.sqlitemvvm.conexion.conexion

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.examen.sqlitemvvm.com.maestre.sqlitemvvm.conexion.model.Abogado

@Database(entities = [Abogado::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun abogadoDAO(): AbogadoDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "abogado.db3"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
