package uz.direction.noteapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import uz.direction.noteapp.models.NoteModel
import uz.direction.noteapp.models.NoteRepository
import uz.direction.noteapp.models.db.AppDatabase
import uz.direction.noteapp.recyclerview.Note

class NoteViewModel(database: AppDatabase): ViewModel() {
    private val notesRepository: NoteRepository = NoteModel(database)

    fun createNote(note: Note) = viewModelScope.async(Dispatchers.IO){
        notesRepository.insertNewNote(note)
    }

    fun updateNote(note: Note) = viewModelScope.async(Dispatchers.IO){
        notesRepository.updateNote(note)
    }
}