package br.com.apass.cartaodevisitas.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.apass.cartaodevisitas.data.CartaoDeVisita
import br.com.apass.cartaodevisitas.databinding.ItemCartaoDeVisitaBinding

class CartaoDeVisitaAdapter: ListAdapter<CartaoDeVisita, CartaoDeVisitaAdapter.ViewHolder>(DiffCallback()) {

    var listernerShare: (View) -> Unit = {}

    inner class ViewHolder(
        private val binding: ItemCartaoDeVisitaBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CartaoDeVisita) {
            binding.tvNome.text = item.nome
            binding.tvTelefone.text = item.telefone
            binding.tvEmail.text = item.email
            binding.tvEmpresa.text = item.empresa
            binding.tvEmail.text = item.fundoPersonalizado
            binding.cvCard.setBackgroundColor(Color.parseColor(item.fundoPersonalizado))
            binding.cvCard.setOnClickListener { listernerShare(it) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val binding = ItemCartaoDeVisitaBinding.inflate(inflate, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DiffCallback: DiffUtil.ItemCallback<CartaoDeVisita>(){
    override fun areItemsTheSame(oldItem: CartaoDeVisita, newItem: CartaoDeVisita) = oldItem == newItem
    override fun areContentsTheSame(oldItem: CartaoDeVisita, newItem: CartaoDeVisita) = oldItem == newItem
}