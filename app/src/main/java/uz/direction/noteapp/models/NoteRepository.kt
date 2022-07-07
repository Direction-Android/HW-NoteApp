package uz.direction.noteapp.models

import kotlinx.coroutines.flow.Flow
import uz.direction.noteapp.recyclerview.Note

interface NoteRepository {
    suspend fun getAllNotes(): Flow<List<Note>>
    suspend fun insertNewNote(note: Note)
    suspend fun updateNote(note: Note)
}