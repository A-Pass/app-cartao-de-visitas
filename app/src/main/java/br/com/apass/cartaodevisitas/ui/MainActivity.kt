package br.com.apass.cartaodevisitas.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import br.com.apass.cartaodevisitas.App
import br.com.apass.cartaodevisitas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: MainViewModel by viewModels() {
        MainViewModelFactory((application as App).repository)
    }

    private val adapter by lazy { CartaoDeVisitaAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(binding.root)
        this.binding.rvCartoes.adapter = adapter
        this.getAllCartoesDeVisitas()
        this.initClicks()
    }

    private fun initClicks() {
        this.binding.fab.setOnClickListener() {
            val intent = Intent(this@MainActivity, AdicionarCartaoDeVisicaActivity::class.java)
            this.startActivity(intent)
        }
    }

    private fun getAllCartoesDeVisitas() {
        this.viewModel.getAll().observe(this) { cartoesDeVisitas ->
            adapter.submitList(cartoesDeVisitas)
        }
    }
}