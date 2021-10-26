package br.com.apass.cartaodevisitas.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.apass.cartaodevisitas.databinding.ActivityAdicionarCartaoDeVisitaBinding

class AdicionarCartaoDeVisicaActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityAdicionarCartaoDeVisitaBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initClicks()
    }

    private fun initClicks() {
        this.binding.btnCancelar.setOnClickListener {
            finish()
        }
    }
}