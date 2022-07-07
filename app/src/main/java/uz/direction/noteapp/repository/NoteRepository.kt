package uz.direction.noteapp.repository

import androidx.lifecycle.LiveData
import uz.direction.noteapp.data.NoteDao
import uz.direction.noteapp.model.Note

interface NoteRepository {

    suspend fun insertNote(note: Note) {
    }

    suspend fun updateNote(note: Note) {
    }

    suspend fun deleteNote(note: Note) {
    }

    suspend fun deleteAllNotes() {
    }
}