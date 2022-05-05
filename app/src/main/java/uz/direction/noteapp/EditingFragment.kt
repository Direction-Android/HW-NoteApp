package uz.direction.noteapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import uz.direction.noteapp.databinding.FragmentEditingBinding

class EditingFragment : Fragment(R.layout.fragment_editing) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val editText = view.findViewById<EditText>(R.id.edit_note_text)
        val editHeader = view.findViewById<EditText>(R.id.edit_note_header)
        editText.setText(requireArguments().get("text").toString())
        editHeader.setText(requireArguments().get("header").toString())
    }

}