package uz.direction.noteapp.ui.fragments.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import uz.direction.noteapp.R
import uz.direction.noteapp.data.model.Note

 class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteVH>() {
    private var notesList: List<Note> = emptyList()
    private var onClick: ((Note, Int) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteVH {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_note_fragment, parent, false)
        return NoteVH(view)
    }


    override fun getItemCount(): Int =notesList.size

    override fun onBindViewHolder(holder: NoteVH, position: Int) {
        holder.onBind(notesList[position], position, onClick ?: { _, _ -> })

    }

    class NoteVH(view: View) : RecyclerView.ViewHolder(view) {
        private val title = itemView.findViewById<TextView>(R.id.note_title)
        private val content = itemView.findViewById<TextView>(R.id.note_content)
        private var currentNote: Note? = null

        fun onBind(
            note: Note,
            position: Int,
            onClick: (Note, Int) -> Unit,
        ) {
            currentNote = note
            title.text = note.title
            content.text = note.text
            itemView.setOnClickListener {
                onClick.invoke(note, position)
                val action =
                    NoteListFragmentDirections.actionMainFragmentToUpdateFragment(note)
                itemView.findNavController().navigate(action)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList: List<Note>) {
        notesList = newList
        notifyDataSetChanged()
    }
}


