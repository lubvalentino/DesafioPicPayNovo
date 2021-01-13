package com.example.DesafioPicPayNovo.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.DesafioPicPayNovo.R
import com.example.DesafioPicPayNovo.model.User
import de.hdodenhof.circleimageview.CircleImageView

class MainAdapter (
        private val userList: List<User>,
    //função lambda
        private val onItemClicked: (Int) -> Unit
        ) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    //infla o nosso layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_list_item, parent, false)
        return ViewHolder(view)
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
    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

        fun bind(user: User, onItemClicked: (Int) -> Unit):Unit = with(itemView){

            Glide.with(itemView.context).load(user.img).into(findViewById<CircleImageView>(R.id.ivMainItemAvatar))

            findViewById<TextView>(R.id.tvMainItemUser).text = user.username
            findViewById<TextView>(R.id.tvMainItemName).text = user.name

            //ação ao clicar no item
            findViewById<ConstraintLayout>(R.id.vgMainItemContainer).setOnClickListener {
                onItemClicked(this@ViewHolder.adapterPosition)
            }
        }
    }
}