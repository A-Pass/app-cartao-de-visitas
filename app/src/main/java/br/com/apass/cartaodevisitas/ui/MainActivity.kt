package br.com.apass.cartaodevisitas.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.apass.cartaodevisitas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        this.initClicks()
    }

    private fun initClicks() {
        this.binding.fab.setOnClickListener() {
            val intent = Intent(this@MainActivity, AdicionarCartaoDeVisicaActivity::class.java)
            startActivity(intent)
        }
    }
}