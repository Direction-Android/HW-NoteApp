package uz.direction.noteapp.views

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.direction.noteapp.R
import uz.direction.noteapp.databinding.FragmentNoteBinding
import uz.direction.noteapp.viewmodels.NoteViewModel

class NoteFragment : Fragment(R.layout.fragment_note) {
    private val noteViewModel: NoteViewModel by viewModels()
    private val viewBinding: FragmentNoteBinding by viewBinding(FragmentNoteBinding::bind)
    private val args: NoteFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.apply {
            notePageHeader.setText(args.note?.header ?: R.string.default_header_text.toString())
            notePageText.setText(args.note?.text ?: R.string.default_note_text.toString())
        }

        viewBinding.saveNoteButton.visibility = View.INVISIBLE
        viewBinding.saveNoteButton.isEnabled = false

        viewBinding.notePageHeader.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                viewBinding.saveNoteButton.visibility = View.VISIBLE
                viewBinding.saveNoteButton.isEnabled = true
            }
        })

        viewBinding.notePageText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                viewBinding.saveNoteButton.visibility = View.VISIBLE
                viewBinding.saveNoteButton.isEnabled = true
            }
        })
    }
}