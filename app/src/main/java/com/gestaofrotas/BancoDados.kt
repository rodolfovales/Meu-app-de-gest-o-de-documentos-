package com.gestaofrotas

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Empresa::class, Documento::class, Usuario::class],
    version = 1
)
abstract class BancoDados : RoomDatabase() {
    companion object {
        @Volatile
        private var INSTANCIA: BancoDados? = null

        fun getInstance(contexto: Context): BancoDados {
            return INSTANCIA ?: synchronized(this) {
                val instancia = Room.databaseBuilder(
                    contexto,
                    BancoDados::class.java,
                    "gestao_frotas.db"
                ).build()
                INSTANCIA = instancia
                instancia
            }
        }
    }
}
