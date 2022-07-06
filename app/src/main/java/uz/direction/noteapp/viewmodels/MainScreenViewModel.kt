package uz.direction.noteapp.viewmodels

import androidx.lifecycle.ViewModel
import uz.direction.noteapp.models.NoteModel
import uz.direction.noteapp.models.NoteRepository
import uz.direction.noteapp.recyclerview.Note

class MainScreenViewModel(): ViewModel() {
    private val notesRepository: NoteRepository = NoteModel()

    fun getNote(position: Int): Note{
        return notesRepository.getNote(position)
    }
}