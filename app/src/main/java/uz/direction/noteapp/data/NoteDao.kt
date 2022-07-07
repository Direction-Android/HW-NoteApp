package uz.direction.noteapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import uz.direction.noteapp.model.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes_table")
    fun getAllData(): LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertText(text: Note)

    @Update
    suspend fun updateText(text: Note)

    @Delete
    suspend fun deleteText(text: Note)

    @Query("DELETE FROM notes_table")
    suspend fun deleteAllNotes()


}