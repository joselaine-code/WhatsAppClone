package br.com.joselaine.whatsappclone.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.joselaine.whatsappclone.R
import br.com.joselaine.whatsappclone.adapter.ChatAdapter
import br.com.joselaine.whatsappclone.databinding.FragmentChatBinding
import br.com.joselaine.whatsappclone.model.ChatModel


class ChatFragment : Fragment() {

    private var binding: FragmentChatBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding?.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listChat = listOf(
            ChatModel("Anitta", "Boa tardeee \uD83C\uDF1E", R.drawable.anitta, "18:30"),
            ChatModel("Felipe Neto", "Já subi o vídeo no YouTube", R.drawable.felipeneto, "17:25"),
            ChatModel("Alok", "Essa vou lançar semana que vem", R.drawable.alok, "16:30"),
            ChatModel("Maisa", "Boom dia \uD83D\uDE34", R.drawable.maisa, "11:30"),
            ChatModel("Cauã Reymond", "Sim, concordo", R.drawable.caua, "11:22"),
            ChatModel("Manu", "Está combinado! \uD83D\uDE00", R.drawable.manu, "10:58"),
            ChatModel("Marília Mendonça", "Pode não, rapaz", R.drawable.marilia, "10:30"),
            ChatModel("Maria", "Somente na semana que vem", R.drawable.mariacasa, "10:22"),
            ChatModel("Tainá", "Segunda temporada vem aí", R.drawable.taina, "08:30"),
            ChatModel("Juanes", "Buen Día, Josy", R.drawable.juanes, "07:30"),
            ChatModel(
                "Flor de Sal",
                "Pedido confirmado \uD83D\uDE80",
                R.drawable.flordesal,
                "Yesterday"
            ),
            ChatModel("Juliette", "É paaau! \uD83C\uDF35", R.drawable.juliette, "Yesterday")
        )


        val chatAdapter = ChatAdapter(listChat) {
            Toast.makeText(context, "${it.nome} enviou mensagem", Toast.LENGTH_SHORT).show()
        }
        binding?.let {
            with(it) {
                binding?.recyclerView?.layoutManager = LinearLayoutManager(context)
                binding?.recyclerView?.adapter = chatAdapter
                binding?.recyclerView?.addItemDecoration(
                    DividerItemDecoration(
                        context,
                        LinearLayoutManager.VERTICAL
                    )
                )
                binding?.recyclerView?.setNestedScrollingEnabled(false)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}