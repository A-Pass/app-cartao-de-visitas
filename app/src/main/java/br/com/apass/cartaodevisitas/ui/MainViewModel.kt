package br.com.apass.cartaodevisitas.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.apass.cartaodevisitas.data.CartaoDeVisita
import br.com.apass.cartaodevisitas.data.CartaoDeVisitaRepository
import java.lang.IllegalArgumentException

class MainViewModel(private val cartaoDeVisitaRepository: CartaoDeVisitaRepository): ViewModel() {
    fun insert(cartaoDeVisita: CartaoDeVisita) {
        cartaoDeVisitaRepository.insert(cartaoDeVisita)
    }
    
    fun getAll(): LiveData<List<CartaoDeVisita>> {
        return this.cartaoDeVisitaRepository.getAll()
    }
}

class MainViewModelFactory(private val repository: CartaoDeVisitaRepository)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class!")
    }
}