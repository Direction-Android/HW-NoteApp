package uz.direction.noteapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

public class NoteAdapter(
    private val note: ArrayList<Note>,
) : RecyclerView.Adapter<NoteAdapter.NoteVH>() {
    private var onClick: ((Note,Int) -> Unit)? = null
    fun setOnClickListener(clickEvent: (Note, Int) -> Unit) {
        onClick = clickEvent
    }
    fun removeNote(position: Int) {
        note.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, note.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteVH {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.main_fragment, parent, false)
        return NoteVH(view)
    }

    override fun onBindViewHolder(holder: NoteVH, position: Int) {
        holder.onBind(note[position])
    }

    override fun getItemCount(): Int {
        return note.size
    }
    class NoteVH(view: View) : RecyclerView.ViewHolder(view) {
        private val title = itemView.findViewById<TextView>(R.id.title)
        private val text = itemView.findViewById<TextView>(R.id.text)
        private var currentNote: Note? = null


        fun onBind(note: Note) {
            currentNote = note
            title.text = note.title
            text.text = note.text

        }
    }
}


