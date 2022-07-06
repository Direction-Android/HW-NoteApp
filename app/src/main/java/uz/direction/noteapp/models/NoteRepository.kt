package uz.direction.noteapp.models

import uz.direction.noteapp.notes
import uz.direction.noteapp.recyclerview.Note

interface NoteRepository {
    fun getNote(position: Int): Note
}