package br.com.apass.cartaodevisitas.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.apass.cartaodevisitas.App
import br.com.apass.cartaodevisitas.R
import br.com.apass.cartaodevisitas.data.CartaoDeVisita
import br.com.apass.cartaodevisitas.databinding.ActivityAdicionarCartaoDeVisitaBinding

class AdicionarCartaoDeVisicaActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityAdicionarCartaoDeVisitaBinding.inflate(layoutInflater)
    }

    private val viewModel: MainViewModel by viewModels() {
        MainViewModelFactory((application as App).repository)
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

        this.binding.btnCadastrar.setOnClickListener {
            val cartaoVisita = CartaoDeVisita(
                nome = this.binding.tilNome.editText?.text.toString(),
                telefone = this.binding.tilTelefone.editText?.text.toString(),
                email = this.binding.tilEmail.editText?.text.toString(),
                empresa = this.binding.tilEmpresa.editText?.text.toString(),
                fundoPersonalizado = this.binding.tilCor.editText?.text.toString()
            )
            viewModel.insert(cartaoVisita)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT)
        }
    }
}