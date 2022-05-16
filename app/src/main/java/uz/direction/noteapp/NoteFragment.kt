package uz.direction.noteapp

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

        if ((args.title).toString() != "Empty") {
            text.text = Editable.Factory.getInstance().newEditable(args.text)
            title.text = Editable.Factory.getInstance().newEditable(args.title)
        }
        saveBtn.setOnClickListener {
            if (title.text.isNotBlank()) {
                val action2 = NoteFragmentDirections.actionNoteFragmentToMainFragment()
                action2.text = text.text.toString()
                action2.title = title.text.toString()
                findNavController().navigate(action2)
            } else {
                Toast.makeText(context, "Header is blank!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}