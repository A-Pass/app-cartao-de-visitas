package br.com.apass.cartaodevisitas.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CartaoDeVisita::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun cartaoDeVisitaDao() : CartaoDeVisitaDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "cartaodevisita.db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}