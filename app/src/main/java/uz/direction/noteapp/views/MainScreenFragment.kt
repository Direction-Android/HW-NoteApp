package uz.direction.noteapp.views

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import uz.direction.noteapp.R
import uz.direction.noteapp.databinding.FragmentMainScreenBinding
import uz.direction.noteapp.models.db.AppDatabase
import uz.direction.noteapp.recyclerview.Note
import uz.direction.noteapp.recyclerview.NotesAdapter
import uz.direction.noteapp.viewmodels.MainScreenViewModel

class MainScreenFragment : Fragment(R.layout.fragment_main_screen) {
    private val viewBinding: FragmentMainScreenBinding by viewBinding(FragmentMainScreenBinding::bind)
    private val noteViewModel by viewModelsFactory {
        MainScreenViewModel(
            Room.databaseBuilder(
                requireContext(),
                AppDatabase::class.java,
                "notes_db"
            ).build()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteViewModel.getNotes()

        lifecycleScope.launch {
            noteViewModel.dataFlow.collect { notes ->
                val notesAdapter = NotesAdapter(notes) { position -> onItemClicked(position) }
                viewBinding.recycleView.apply {
                    layoutManager =
                        LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    adapter = notesAdapter
                }
            }
        }

        viewBinding.addNoteButton.setOnClickListener { createNote() }
    }

    private fun onItemClicked(position: Int) {
        val action =
            MainScreenFragmentDirections.actionMainScreenFragmentToNoteFragment(
                note = noteViewModel.notes[position]
            )
        findNavController().navigate(action)
    }

    private fun createNote() {
        val action = MainScreenFragmentDirections.actionMainScreenFragmentToNoteFragment(
            note = Note(header = "Title", text = "Text", id = null)
        )
        findNavController().navigate(action)
    }
}

inline fun <reified T : ViewModel> Fragment.viewModelsFactory(crossinline viewModelInitialization: () -> T): Lazy<T> {
    return viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return viewModelInitialization.invoke() as T
            }
        }
    }
}