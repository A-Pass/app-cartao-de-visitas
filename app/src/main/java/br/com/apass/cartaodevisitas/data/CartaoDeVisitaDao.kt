package br.com.apass.cartaodevisitas.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query

@Dao
interface CartaoDeVisitaDao {

    @Query("SELECT * FROM cartaodevisita")
    fun getAll(): LiveData<List<CartaoDeVisita>>

    @Insert(onConflict = IGNORE)
    suspend fun insert(cartaoDeVisita: CartaoDeVisita)
}