package uz.direction.noteapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "notes_table")
data class Note(
    val title: String,
    val text: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
) : Parcelable