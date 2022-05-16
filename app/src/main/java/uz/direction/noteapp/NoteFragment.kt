package uz.direction.noteapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class NoteFragment : Fragment(R.layout.note_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args by navArgs<NoteFragmentArgs>()

        val saveBtn = view.findViewById<Button>(R.id.save_button)
        val text = view.findViewById<EditText>(R.id.editText)
        val title = view.findViewById<EditText>(R.id.editTitle)

        val editable =
            requireContext().getSharedPreferences("shared_pref", Context.MODE_PRIVATE).edit()

        if ((args.title).toString() != "Empty") {
            text.text = Editable.Factory.getInstance().newEditable(args.text)
            title.text = Editable.Factory.getInstance().newEditable(args.title)
        }
        saveBtn.setOnClickListener {
            if (title.text.isNotBlank()) {
                editable.putString("text", text.text.toString())
                editable.putString("title", title.text.toString())
                editable.apply()
                Toast.makeText(context, "Saved!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(NoteFragmentDirections.actionNoteFragmentToMainFragment())
            } else {
                Toast.makeText(context, "Header is blank!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}