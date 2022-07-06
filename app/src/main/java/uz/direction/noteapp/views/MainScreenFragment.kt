package uz.direction.noteapp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.direction.noteapp.R
import uz.direction.noteapp.databinding.FragmentMainScreenBinding
import uz.direction.noteapp.notes
import uz.direction.noteapp.recyclerview.NotesAdapter
import uz.direction.noteapp.viewmodels.NoteViewModel

class MainScreenFragment : Fragment(R.layout.fragment_main_screen) {
    private val viewBinding: FragmentMainScreenBinding by viewBinding(FragmentMainScreenBinding::bind)
    private val noteViewMode: NoteViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

                val notesAdapter = NotesAdapter(notes)
        viewBinding.recycleView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = notesAdapter
        }
    }
}