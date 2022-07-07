package uz.direction.noteapp.models.db

import androidx.room.*
import uz.direction.noteapp.recyclerview.Note

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotes(vararg notes: Note)

    @Update
    fun updateNotes(vararg notes: Note)

    @Delete
    fun deleteUsers(vararg notes: Note)

    @Query("SELECT * FROM notes")
    fun getAllNotes(): List<Note>
}