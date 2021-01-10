package com.example.DesafioPicPayNovo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter (
    val userList: List<User>
        ) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    //infla o nosso layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_list_item, parent, false)
        return ViewHolder(view)
    }

    //coloca os itens na lista baseado em cada posição
    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    //conta o tamanho da lista
    override fun getItemCount(): Int {
        return userList.size
    }

    //classe que vai plotar os dados
    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

        fun bind(user:User):Unit = with(itemView){
            findViewById<TextView>(R.id.tvMainItemUser).text = user.userId
            findViewById<TextView>(R.id.tvMainItemName).text = user.userName
        }
    }
}