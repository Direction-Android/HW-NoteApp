package uz.direction.noteapp.ui.fragments.add

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import uz.direction.noteapp.R
import uz.direction.noteapp.data.model.Note
import uz.direction.noteapp.databinding.AddFragmentBinding
import uz.direction.noteapp.ui.viewModel.NoteViewModel

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
        setHasOptionsMenu(true)
        noteViewModel = ViewModelProvider(this)[NoteViewModel::class.java]

        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.action_menu, menu)
        menu.findItem(R.id.menu_edit).isVisible = isHidden
        menu.findItem(R.id.menu_delete).isVisible = isHidden
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        addNoteToDB()
        return super.onOptionsItemSelected(item)
    }

    private fun addNoteToDB() {

        val content = binding.addContentEt
        val title = binding.addTitleEt

        if (title.text.isNotBlank()) {

            val note = Note(title.text.toString(), content.text.toString())
            noteViewModel.insertNote(note)
            findNavController().navigate(R.id.action_noteFragment_to_mainFragment)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_SHORT)
                .show()
        } else {
            Toast.makeText(requireContext(), "Title is EMPTY", Toast.LENGTH_SHORT).show()
        }
    }
}