package com.example.DesafioPicPayNovo.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.DesafioPicPayNovo.databinding.MainListItemBinding
import com.example.DesafioPicPayNovo.model.UsersItem

class MainAdapter (
    private val userList: List<UsersItem>,
    //função lambda
    private val onItemClicked: (Int) -> Unit
        ) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    //infla o nosso layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = MainListItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    //coloca os itens na lista baseado em cada posição
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(userList[position], onItemClicked)
    }

    //conta o tamanho da lista
    override fun getItemCount(): Int {
        return userList.size
    }

    //classe que vai plotar os dados
    class ViewHolder(private val binding: MainListItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(usersItem: UsersItem, onItemClicked: (Int) -> Unit):Unit = with(itemView){

            Glide.with(itemView.context).load(usersItem.img).into(binding.ivMainItemAvatar)

            binding.tvMainItemUser.text = usersItem.username
            binding.tvMainItemName.text = usersItem.name

            //ação ao clicar no item
            binding.vgMainItemContainer.setOnClickListener {
                onItemClicked(this@ViewHolder.adapterPosition)
            }
        }
    }
}