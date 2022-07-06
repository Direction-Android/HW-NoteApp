package uz.direction.noteapp.recyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Note(val header: String,
                val text: String): Parcelable
