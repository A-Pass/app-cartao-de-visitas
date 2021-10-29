package br.com.apass.cartaodevisitas.data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CartaoDeVisitaRepository(private val cartaoVisitaDao: CartaoDeVisitaDao) {
    fun getAll(): LiveData<List<CartaoDeVisita>> = this.cartaoVisitaDao.getAll()
    fun insert(cartaoDeVisita: CartaoDeVisita) = runBlocking {
        launch(Dispatchers.IO) {
            cartaoVisitaDao.insert(
                cartaoDeVisita
            )
        }
    }
}