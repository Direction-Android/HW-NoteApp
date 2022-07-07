package uz.direction.noteapp.fragments.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import uz.direction.noteapp.R
import uz.direction.noteapp.model.Note
import uz.direction.noteapp.databinding.AddFragmentBinding
import uz.direction.noteapp.viewModel.NoteViewModel

class AddFragment : Fragment(R.layout.add_fragment) {

    private var _binding: AddFragmentBinding? = null
    private val binding: AddFragmentBinding get() = _binding!!
    private lateinit var noteViewModel: NoteViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = AddFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        noteViewModel = ViewModelProvider(this)[NoteViewModel::class.java]
        val saveBtn = binding.saveButton
        val content = binding.addContentEt
        val title = binding.addTitleEt

        saveBtn.setOnClickListener {
            addNoteToDB(title, content, noteViewModel)
        }
    }

    private fun addNoteToDB(title: EditText, content: EditText, noteViewModel: NoteViewModel) {

        val title = title.text.toString()
        val content = content.text.toString()

        if (title.isNotBlank()) {

            val note = Note(title, content)
            noteViewModel.insertNote(note)
            findNavController().navigate(R.id.action_noteFragment_to_mainFragment)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_SHORT)
                .show()
        } else {
            Toast.makeText(requireContext(), "Title is EMPTY", Toast.LENGTH_SHORT).show()
        }
    }
}