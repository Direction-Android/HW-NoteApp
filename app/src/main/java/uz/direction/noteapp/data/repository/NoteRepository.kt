package uz.direction.noteapp.data.repository

import uz.direction.noteapp.data.model.Note

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