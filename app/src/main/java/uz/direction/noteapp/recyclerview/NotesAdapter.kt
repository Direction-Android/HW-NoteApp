package uz.direction.noteapp.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.direction.noteapp.R

class NotesAdapter(private val list: List<Note>) :
    RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

        class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
            val noteHeader: TextView = itemView.findViewById(R.id.note_header)
            val noteText: TextView = itemView.findViewById(R.id.note_text)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemViewModel = list[position]

        holder.noteHeader.text = itemViewModel.header
        holder.noteText.text = itemViewModel.text
    }

    override fun getItemCount(): Int = list.size

}