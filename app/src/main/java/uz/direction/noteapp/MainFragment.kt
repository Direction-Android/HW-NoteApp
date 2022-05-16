package uz.direction.noteapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class MainFragment : Fragment(R.layout.main_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = view.findViewById<TextView>(R.id.title)
        val text = view.findViewById<TextView>(R.id.text)
        val addBtn = view.findViewById<Button>(R.id.button)


        val saved=requireContext().getSharedPreferences("shared_pref", Context.MODE_PRIVATE)
        val savedTitle=saved.getString("title","")
        val savedText=saved.getString("text","")

        title.text = savedTitle
        text.text =savedText



        addBtn.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToNoteFragment(
                text.text.toString(),
                title.text.toString()
            )
            findNavController().navigate(action)
        }

    }
}
