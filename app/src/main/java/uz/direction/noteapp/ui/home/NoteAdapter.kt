package uz.direction.noteapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.direction.noteapp.R
import uz.direction.noteapp.databinding.ItemNoteBinding
import uz.direction.noteapp.model.Note

class NoteAdapter(
    private val notes: ArrayList<Note>
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.onBind(notes[position])
    }

    override fun getItemCount() = notes.size

    class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding by viewBinding<ItemNoteBinding>()

        fun onBind(note: Note) {
            binding.apply {
                tvText.text = note.text
                tvTitle.text = note.title
            }
        }

    }

}
