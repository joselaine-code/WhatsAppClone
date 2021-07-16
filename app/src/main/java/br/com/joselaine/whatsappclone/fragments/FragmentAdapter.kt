package br.com.joselaine.whatsappclone.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            1 ->  ChatFragment()
            2 ->  StatusFragment()
            3 ->  CallFragment()
            else -> CameraFragment()
        }
    }

    override fun getItemCount() = 4
}