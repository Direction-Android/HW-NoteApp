package uz.direction.noteapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.direction.noteapp.data.NoteDatabase
import uz.direction.noteapp.model.Note
import uz.direction.noteapp.repository.NoteRepositoryImpl

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<Note>>
    private val repository: NoteRepositoryImpl

    init {
        val noteDao = NoteDatabase.getDatabaseInstance(application).getDao()
        repository = NoteRepositoryImpl(noteDao)
        readAllData = repository.readAllData
    }

    fun insertNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertNote(note)
        }
    }

    fun updateUser(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateNote(note)
        }
    }

    fun deleteUser(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteNote(note)
        }
    }

    fun deleteAllUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllNotes()
        }
    }

//    sealed class Resource<T> {
//        class Loading<T> : Resource<T>()
//        class Success<T>(val data: T) : Resource<T>()
//        class Error<T>(val error: Throwable) : Resource<T>()
//
//    }

}