package br.com.joselaine.whatsappclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.joselaine.whatsappclone.R
import br.com.joselaine.whatsappclone.databinding.ChatItemBinding
import br.com.joselaine.whatsappclone.model.ChatModel

class ChatAdapter(
    private val listChat: List<ChatModel>,
    private val onClickListener: (chatModel: ChatModel) -> Unit
) : RecyclerView.Adapter<ChatAdapter.MusicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val binding = ChatItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MusicViewHolder(binding)
    }

    //Essa parte do código que efetiva os dados da lista dentro do View Holder (XML)
    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.bind(listChat[position], onClickListener)
    }

    override fun getItemCount() = listChat.size

    inner class MusicViewHolder(private val binding: ChatItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            chat: ChatModel,
            onClickListener: (chat: ChatModel) -> Unit
        ) {
            binding.nome.text = chat.nome
            binding.mensagem.text = chat.mensagem
            binding.horario.text = chat.horario
            binding.ivPerfil.setImageResource(chat.foto)
            binding.vgCardView.setOnClickListener {
                onClickListener(chat)
            }
        }

    }
}