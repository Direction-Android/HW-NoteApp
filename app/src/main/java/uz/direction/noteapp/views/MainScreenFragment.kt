package uz.direction.noteapp.views

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.direction.noteapp.R
import uz.direction.noteapp.databinding.FragmentMainScreenBinding
import uz.direction.noteapp.models.NoteModel
import uz.direction.noteapp.notes
import uz.direction.noteapp.recyclerview.Note
import uz.direction.noteapp.recyclerview.NotesAdapter
import uz.direction.noteapp.viewmodels.MainScreenViewModel

class MainScreenFragment : Fragment(R.layout.fragment_main_screen) {
    private val viewBinding: FragmentMainScreenBinding by viewBinding(FragmentMainScreenBinding::bind)
    private val noteViewModel: MainScreenViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val notesAdapter = NotesAdapter(notes) { position -> onItemClicked(position) }
        viewBinding.recycleView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = notesAdapter
        }

        viewBinding.addNoteButton.setOnClickListener{ createNote() }
    }

    private fun onItemClicked(position: Int) {
        val action =
            MainScreenFragmentDirections.actionMainScreenFragmentToNoteFragment(
                note = noteViewModel.getNote(
                    position
                )
            )
        findNavController().navigate(action)
    }

    private fun createNote(){
        val action = MainScreenFragmentDirections.actionMainScreenFragmentToNoteFragment(
            note = Note(header = "Title", text = "Text")
        )
        findNavController().navigate(action)
    }
}