package uz.direction.noteapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.direction.noteapp.data.model.Note

@Database(entities = [Note::class], version = 1)

abstract class NoteDatabase : RoomDatabase() {

    abstract fun getDao(): NoteDao

    companion object {
        private var instance: NoteDatabase? = null
        fun getDatabaseInstance(context: Context): NoteDatabase {
            return instance ?: Room.databaseBuilder(
                context,
                NoteDatabase::class.java, "my_db"
            )
                .fallbackToDestructiveMigration()
                .build().also {
                    instance = it
                }
        }
    }

}