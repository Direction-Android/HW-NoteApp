package uz.direction.noteapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.direction.noteapp.models.NoteModel
import uz.direction.noteapp.models.NoteRepository
import uz.direction.noteapp.models.db.AppDatabase
import uz.direction.noteapp.recyclerview.Note

class MainScreenViewModel(database: AppDatabase): ViewModel() {
    private val notesRepository: NoteRepository = NoteModel(database)
    private val _dataFlow = MutableStateFlow(listOf<Note>())
    val dataFlow = _dataFlow.asStateFlow()
    private var _notes = listOf<Note>()
    val notes: List<Note>
        get() = _notes

    fun getNotes() = viewModelScope.launch(Dispatchers.IO){
        updateNoteList().await()
        _dataFlow.value = notes
    }

    private suspend fun updateNoteList() = viewModelScope.async(Dispatchers.IO){
        notesRepository.getAllNotes().collect{ notes ->
            _notes = notes
        }
    }
}