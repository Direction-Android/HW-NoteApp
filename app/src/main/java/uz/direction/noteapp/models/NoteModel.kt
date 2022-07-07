package uz.direction.noteapp.models

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.direction.noteapp.models.db.AppDatabase
import uz.direction.noteapp.recyclerview.Note

class NoteModel(database: AppDatabase): NoteRepository {
    private val noteDao = database.noteDao()

    override suspend fun getAllNotes(): Flow<List<Note>> = flow{
        emit(noteDao.getAllNotes())
    }

    override suspend fun insertNewNote(note: Note) {
        noteDao.insertNotes(note)
    }

    override suspend fun updateNote(note: Note){
        noteDao.updateNotes(note)
    }
}