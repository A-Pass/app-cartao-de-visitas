package br.com.apass.cartaodevisitas

import android.app.Application
import br.com.apass.cartaodevisitas.data.AppDatabase
import br.com.apass.cartaodevisitas.data.CartaoDeVisitaRepository

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { CartaoDeVisitaRepository(database.cartaoDeVisitaDao()) }
}